package com.example.sportclub.services.impl;

import com.example.sportclub.exceptions.MissingPlayerException;
import com.example.sportclub.model.database.DAOUser;
import com.example.sportclub.model.database.Player;
import com.example.sportclub.model.enums.PlayerStatus;
import com.example.sportclub.model.requests.AddNewPlayerRequest;
import com.example.sportclub.model.requests.ChangePlayerStatusRequest;
import com.example.sportclub.model.requests.DeletePlayerRequest;
import com.example.sportclub.model.requests.EditPlayerRequest;
import com.example.sportclub.model.responses.PlayerResponse;
import com.example.sportclub.repo.PlayerEventRepository;
import com.example.sportclub.repo.PlayerRepository;
import com.example.sportclub.repo.UserDaoRepository;
import com.example.sportclub.services.PlayerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final UserDaoRepository userDaoRepository;
    private final PlayerEventRepository playerEventRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository, UserDaoRepository userDaoRepository, PlayerEventRepository playerEventRepository) {
        this.playerRepository = playerRepository;
        this.userDaoRepository = userDaoRepository;
        this.playerEventRepository = playerEventRepository;
    }

    @Override
    public PlayerResponse addPlayer(AddNewPlayerRequest addNewPlayerRequest) {

        Player player = new Player(
                addNewPlayerRequest.getName(),
                addNewPlayerRequest.getLastName(),
                addNewPlayerRequest.getBirthDate(),
                addNewPlayerRequest.getEmail(),
                addNewPlayerRequest.getPosition(),
                PlayerStatus.MAIN_TEAM, null);

        userDaoRepository.findByEmail(addNewPlayerRequest.getEmail())
                .ifPresent(daoUser -> {
                    player.setUser(daoUser);
                    daoUser.setRole("ROLE_PLAYER");
                    daoUser.setPlayer(player);
                });

        Player savedPlayer = playerRepository.save(player);

        return new PlayerResponse(
                savedPlayer.getName(),
                savedPlayer.getLastName(),
                savedPlayer.getBirthDate(),
                savedPlayer.getEmail(),
                savedPlayer.getPosition(),
                savedPlayer.getPlayerStatus(), false);
    }

    @Override
    public PlayerResponse editPlayer(EditPlayerRequest editPlayerRequest) {

        Player updatedPlayer = playerRepository.findByEmail(editPlayerRequest.getEmail())
                .map(player -> {
                    Player editedPlayer = new Player();
                    editedPlayer.setId(player.getId());
                    editedPlayer.setEmail(editPlayerRequest.getEmail());
                    editedPlayer.setName(editPlayerRequest.getName());
                    editedPlayer.setLastName(editPlayerRequest.getLastName());
                    editedPlayer.setBirthDate(editPlayerRequest.getBirthDate());
                    editedPlayer.setPosition(editPlayerRequest.getPosition());
                    editedPlayer.setPlayerStatus(player.getPlayerStatus());
                    return editedPlayer;
                }).orElseThrow(() -> new MissingPlayerException("Missing player"));

        Player save = playerRepository.save(updatedPlayer);
        return new PlayerResponse(save.getName(), save.getLastName(), save.getBirthDate(), save.getEmail(), save.getPosition(), save.getPlayerStatus(), false);
    }

    @Override
    public List<PlayerResponse> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(player -> new PlayerResponse(player.getName(),
                        player.getLastName(),
                        player.getBirthDate(),
                        player.getEmail(),
                        player.getPosition(),
                        player.getPlayerStatus(), false)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deletePlayer(DeletePlayerRequest deletePlayerRequest) {

        this.playerRepository.findByEmail(deletePlayerRequest.getEmail())
                .ifPresent(player -> {
                    DAOUser user = player.getUser();
                    if (player.getEvents() != null && !player.getEvents().isEmpty()) {
                        playerEventRepository.deleteAll(player.getEvents());
                    }
                    if (user != null) {
                        user.setPlayer(null);
                        user.setRole("ROLE_USER");
                        player.setUser(null);
                        userDaoRepository.save(user);
                    }
                    player.setEvents(null);
                    this.playerRepository.delete(player);
                });
    }

    @Override
    public PlayerResponse changePlayerStatus(ChangePlayerStatusRequest changePlayerStatusRequest) {

        Player updatedPlayer = playerRepository.findByEmail(changePlayerStatusRequest.getEmail())
                .map(player -> {
                    player.setPlayerStatus(changePlayerStatusRequest.getPlayerStatus());
                    return player;
                }).orElseThrow(() -> new MissingPlayerException("Missing player"));

        Player save = playerRepository.save(updatedPlayer);
        return new PlayerResponse(save.getName(), save.getLastName(), save.getBirthDate(), save.getEmail(), save.getPosition(), save.getPlayerStatus(), false);
    }
}
