package com.example.sportclub.services;

import com.example.sportclub.model.requests.AddNewPlayerRequest;
import com.example.sportclub.model.requests.ChangePlayerStatusRequest;
import com.example.sportclub.model.requests.DeletePlayerRequest;
import com.example.sportclub.model.requests.EditPlayerRequest;
import com.example.sportclub.model.responses.PlayerResponse;

import java.util.List;

public interface PlayerService {

    PlayerResponse addPlayer(AddNewPlayerRequest addNewPlayerRequest);

    PlayerResponse editPlayer(EditPlayerRequest editPlayerRequest);

    List<PlayerResponse> getAllPlayers();

    void deletePlayer(DeletePlayerRequest deletePlayerRequest);

    PlayerResponse changePlayerStatus(ChangePlayerStatusRequest changePlayerStatusRequest);
}
