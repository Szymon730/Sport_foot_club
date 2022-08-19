package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.EventLocation;
import com.example.sportclub.model.requests.AddNewEventLocationRequest;
import com.example.sportclub.model.responses.AvailableEventLocationsResponse;
import com.example.sportclub.model.responses.EventLocationResponse;
import com.example.sportclub.repo.EventLocationRepository;
import com.example.sportclub.services.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EventLocationServiceImpl implements EventLocationService {

    private final EventLocationRepository eventLocationRepository;

    @Autowired
    public EventLocationServiceImpl(final EventLocationRepository eventLocationRepository) {
        this.eventLocationRepository = eventLocationRepository;
    }

    @Override
    public void addEventLocation(AddNewEventLocationRequest addNewEventLocationRequest) {
        Optional.ofNullable(addNewEventLocationRequest).ifPresent(request -> {
            eventLocationRepository.save(mapAddNewEventLocationRequestToEventLocation(request));
        });
    }

    @Override
    public AvailableEventLocationsResponse getAvailableEventLocations() {
        List<EventLocation> all = eventLocationRepository.findAll();
        return new AvailableEventLocationsResponse(
                all.stream()
                        .map(eventLocation -> new EventLocationResponse(eventLocation.getId(),
                                eventLocation.getAddress(),
                                eventLocation.getDescription(),
                                eventLocation.getEmail(),
                                eventLocation.getName(),
                                eventLocation.getPhone())
                        ).collect(Collectors.toList()));
    }

    private EventLocation mapAddNewEventLocationRequestToEventLocation(AddNewEventLocationRequest addNewEventLocationRequest) {
        return new EventLocation(null, addNewEventLocationRequest.getAddress(),
                addNewEventLocationRequest.getDescription(),
                addNewEventLocationRequest.getEmail(),
                addNewEventLocationRequest.getName(),
                addNewEventLocationRequest.getPhone());

    }

}
