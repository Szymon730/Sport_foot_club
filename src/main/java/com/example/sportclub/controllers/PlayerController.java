package com.example.sportclub.controllers;

import com.example.sportclub.model.requests.AddNewPlayerRequest;
import com.example.sportclub.model.requests.ChangePlayerStatusRequest;
import com.example.sportclub.model.requests.DeletePlayerRequest;
import com.example.sportclub.model.requests.EditPlayerRequest;
import com.example.sportclub.model.responses.PlayerResponse;
import com.example.sportclub.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {


    private final PlayerService playerService;

    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<?> getAllPlayers() {
        List<PlayerResponse> allPlayers = playerService.getAllPlayers();
        return ResponseEntity.ok(allPlayers);
    }

    @PostMapping("/player")
    public ResponseEntity<PlayerResponse> addNewPlayer(@RequestBody AddNewPlayerRequest addNewPlayerRequest) {
        PlayerResponse playerResponse = playerService.addPlayer(addNewPlayerRequest);
        return ResponseEntity.ok(playerResponse);
    }

    @PutMapping("/player")
    public ResponseEntity<PlayerResponse> editPlayer(@RequestBody EditPlayerRequest editPlayerRequest) {
        PlayerResponse playerResponse = playerService.editPlayer(editPlayerRequest);
        return ResponseEntity.ok(playerResponse);
    }

    @PutMapping("/player/changeStatus")
    public ResponseEntity<PlayerResponse> changePlayerStatus(@RequestBody ChangePlayerStatusRequest changePlayerStatusRequest) {
        PlayerResponse playerResponse = playerService.changePlayerStatus(changePlayerStatusRequest);
        return ResponseEntity.ok(playerResponse);
    }

    @DeleteMapping("/player")
    public ResponseEntity<?> deletePlayer(@RequestBody DeletePlayerRequest deletePlayerRequest) {
        playerService.deletePlayer(deletePlayerRequest);
        return ResponseEntity.ok().build();
    }
}
