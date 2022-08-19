package com.example.sportclub.services.impl;

import com.example.sportclub.exceptions.MissingPlayerException;
import com.example.sportclub.model.database.DAOUser;
import com.example.sportclub.model.database.Event;
import com.example.sportclub.model.database.EventLocation;
import com.example.sportclub.model.database.Player;
import com.example.sportclub.model.database.PlayerEvent;
import com.example.sportclub.model.database.key.PlayerEventKey;
import com.example.sportclub.model.requests.CreateEventRequest;
import com.example.sportclub.model.responses.EventResponse;
import com.example.sportclub.model.responses.PlayerResponse;
import com.example.sportclub.repo.EventLocationRepository;
import com.example.sportclub.repo.EventRepository;
import com.example.sportclub.repo.PlayerEventRepository;
import com.example.sportclub.repo.PlayerRepository;
import com.example.sportclub.repo.UserDaoRepository;
import com.example.sportclub.services.EventService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PlayerRepository playerRepository;
    private final EventLocationRepository eventLocationRepository;
    private final PlayerEventRepository playerEventRepository;
    private final UserDaoRepository userDaoRepository;

    public EventServiceImpl(EventRepository eventRepository,
                            PlayerRepository playerRepository,
                            EventLocationRepository eventLocationRepository,
                            PlayerEventRepository playerEventRepository, UserDaoRepository userDaoRepository) {
        this.eventRepository = eventRepository;
        this.playerRepository = playerRepository;
        this.eventLocationRepository = eventLocationRepository;
        this.playerEventRepository = playerEventRepository;
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public void createEvent(CreateEventRequest createEventRequest) {
        if (createEventRequest != null) {
            Event event = new Event(null,
                    createEventRequest.getCategory(),
                    createEventRequest.getDateTime(),
                    createEventRequest.getDescription(),
                    eventLocationRepository.findById(createEventRequest.getLocationId()).orElse(null),
                    createEventRequest.getTeamSize(),
                    null
            );
            event.setPlayers(createEventRequest.getSelectedPlayers().stream()
                    .map(addNewPlayerRequest -> {
                        return playerRepository
                                .findByEmail(addNewPlayerRequest.getEmail())
                                .map(player -> {
                                    PlayerEvent playerEvent = new PlayerEvent();
                                    playerEvent.setId(new PlayerEventKey(player.getId(), event.getId()));
                                    playerEvent.setEvent(event);
                                    playerEvent.setPlayer(player);
                                    return playerEvent;
                                })
                                .orElse(null);

                    }).collect(Collectors.toSet()));


            eventRepository.save(event);
        }
    }

    @Override
    public List<EventResponse> getEvents(String userEmail) {
        DAOUser user = userDaoRepository.findByEmail(userEmail)
                .orElseThrow(() -> new MissingPlayerException("Invalid user"));
        List<Event> byDateTimeAfter;
        if ("ROLE_TRAINER".equals(user.getRole())) {
            byDateTimeAfter = eventRepository.findByDateTimeAfter(LocalDateTime.now());
        } else if ("ROLE_PLAYER".equals(user.getRole())) {
            byDateTimeAfter = playerRepository.findByEmail(userEmail)
                    .map(Player::getEvents)
                    .orElse(Collections.emptySet())
                    .stream()
                    .map(playerEvent -> {
                        Event event = playerEvent.getEvent();
                        event.setPlayers(event.getPlayers().stream()
                                .filter(playerEvent1 -> playerEvent1.getPlayer()
                                        .getEmail()
                                        .equals(userEmail))
                                .collect(Collectors.toSet()));
                        return event;
                    })
                    .filter(event -> event.getDateTime().isAfter(LocalDateTime.now()))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

        return byDateTimeAfter.stream()
                .map(event -> {
                    EventLocation eventLocation = Optional.ofNullable(event.getEventLocation()).orElse(new EventLocation());
                    return new EventResponse(event.getCategory(),
                            event.getDateTime(),
                            event.getDescription(),
                            eventLocation.getName(),
                            event.getTeamSize(),
                            event.getEventCode(),
                            Optional.ofNullable(event.getPlayers())
                                    .orElse(Collections.emptySet())
                                    .stream()
                                    .filter(playerEvent -> !Objects.isNull(playerEvent.getPlayer()))
                                    .map(playerEvent -> {
                                        Player player = playerEvent.getPlayer();
                                        return new PlayerResponse(player.getName(),
                                                player.getLastName(),
                                                player.getBirthDate(),
                                                player.getEmail(),
                                                player.getPosition(),
                                                player.getPlayerStatus(),
                                                playerEvent.isConfirmed());
                                    })
                                    .collect(Collectors.toList()));
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteEvent(UUID eventCode) {
        this.eventRepository.findByEventCode(eventCode)
                .ifPresent(event -> {
                    if (event.getPlayers() != null && !event.getPlayers().isEmpty()) {
                        playerEventRepository.deleteAll(event.getPlayers());
                    }
                    event.setPlayers(null);
                    eventRepository.delete(event);
                });
    }

    @Override
    public void confirmEventAttendance(UUID eventCode, String userEmail) {
        this.playerEventRepository.findByEvent_EventCodeAndPlayer_Email(eventCode, userEmail)
                .ifPresent(playerEvent -> {
                    playerEvent.setConfirmed(true);
                    playerEventRepository.save(playerEvent);
                });
    }
}
