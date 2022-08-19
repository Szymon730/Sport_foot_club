package com.example.sportclub.model.requests;

import com.example.sportclub.model.enums.PlayerStatus;

public class ChangePlayerStatusRequest {

    private String email;
    private PlayerStatus playerStatus;

    public ChangePlayerStatusRequest() {
    }

    public ChangePlayerStatusRequest(String email, PlayerStatus playerStatus) {
        this.email = email;
        this.playerStatus = playerStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
}
