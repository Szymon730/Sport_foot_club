package com.example.sportclub.model.responses;

import java.util.List;

public class AvailableEventLocationsResponse {

    private List<EventLocationResponse> eventLocations;

    public AvailableEventLocationsResponse() {
    }

    public AvailableEventLocationsResponse(List<EventLocationResponse> eventLocations) {
        this.eventLocations = eventLocations;
    }

    public List<EventLocationResponse> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(List<EventLocationResponse> eventLocations) {
        this.eventLocations = eventLocations;
    }
}
