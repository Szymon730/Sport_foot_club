package com.example.sportclub.services;

import com.example.sportclub.model.requests.CreateEventRequest;
import com.example.sportclub.model.responses.EventResponse;

import java.util.List;
import java.util.UUID;

public interface EventService {
    void createEvent(CreateEventRequest createEventRequest);

    List<EventResponse> getEvents(String userEmail);

    void deleteEvent(UUID eventCode);

    void confirmEventAttendance(UUID eventCode, String nameUser);
}
