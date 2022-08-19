package com.example.sportclub.model.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class CreateEventRequest {

    @NotBlank(message = "Category is mandatory")
    private String category;
    @NotNull(message = "Date is mandatory")
    private LocalDateTime dateTime;
    private String description;
    @NotNull(message = "Location is mandatory")
    private Long locationId;
    @NotNull
    private Integer teamSize;
    private List<AddNewPlayerRequest> selectedPlayers;

    public CreateEventRequest() {
    }

    public CreateEventRequest(String category, LocalDateTime dateTime, String description, Long locationId, Integer teamSize, List<AddNewPlayerRequest> selectedPlayers) {
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
        this.locationId = locationId;
        this.teamSize = teamSize;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "CreateEventRequest{" +
                "category='" + category + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", locationId=" + locationId +
                ", teamSize=" + teamSize +
                '}';
    }

    public List<AddNewPlayerRequest> getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(List<AddNewPlayerRequest> selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }
}
