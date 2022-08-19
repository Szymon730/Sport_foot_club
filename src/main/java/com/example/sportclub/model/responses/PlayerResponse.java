package com.example.sportclub.model.responses;

import com.example.sportclub.model.enums.PlayerStatus;

public class PlayerResponse {

    private String name;
    private String lastName;
    private String birthDate;
    private String email;
    private String position;
    private PlayerStatus playerStatus;
    private boolean confirmedAttendance;

    public PlayerResponse() {
    }

    public PlayerResponse(String name, String lastName, String birthDate, String email, String position, PlayerStatus playerStatus, boolean confirmedAttendance) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.position = position;
        this.playerStatus = playerStatus;
        this.confirmedAttendance = confirmedAttendance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public String toString() {
        return "PlayerResponse{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", playerStatus=" + playerStatus +
                '}';
    }

    public boolean isConfirmedAttendance() {
        return confirmedAttendance;
    }

    public void setConfirmedAttendance(boolean confirmedAttendance) {
        this.confirmedAttendance = confirmedAttendance;
    }
}
