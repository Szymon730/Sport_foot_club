package com.example.sportclub.model.responses;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class EventResponse {

    private String category;
    private LocalDateTime dateTime;
    private String description;
    private String eventLocation;
    private Integer teamSize;
    private UUID eventCode;
    private List<PlayerResponse> selectedPlayers;

    public EventResponse() {
    }

    public EventResponse(String category, LocalDateTime dateTime, String description, String eventLocation, Integer teamSize, UUID eventCode, List<PlayerResponse> selectedPlayers) {
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
        this.eventLocation = eventLocation;
        this.teamSize = teamSize;
        this.eventCode = eventCode;
        this.selectedPlayers = selectedPlayers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public List<PlayerResponse> getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(List<PlayerResponse> selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    public UUID getEventCode() {
        return eventCode;
    }

    public void setEventCode(UUID eventCode) {
        this.eventCode = eventCode;
    }
}
