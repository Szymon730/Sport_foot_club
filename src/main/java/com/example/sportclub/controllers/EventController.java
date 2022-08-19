package com.example.sportclub.controllers;

import com.example.sportclub.model.requests.CreateEventRequest;
import com.example.sportclub.model.responses.EventResponse;
import com.example.sportclub.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
public class EventController {

    private final EventService eventService;

    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/event/create")
    public ResponseEntity<Void> createEvent(@Valid @RequestBody CreateEventRequest createEventRequest) {
        eventService.createEvent(createEventRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/events")
    public ResponseEntity<Map<String, List<EventResponse>>> getEvents(Principal principal) {
        return ResponseEntity.ok(Collections.singletonMap("events", eventService.getEvents(principal.getName())));
    }

    @DeleteMapping("/event/{eventCode}")
    public ResponseEntity<?> deleteEvent(@PathVariable UUID eventCode) {
        eventService.deleteEvent(eventCode);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/event/{eventCode}/confirm/attendance")
    public ResponseEntity<Void> confirmAttendance(@PathVariable UUID eventCode,
                                       Principal principal) {
        eventService.confirmEventAttendance(eventCode,principal.getName());
        return ResponseEntity.ok().build();
    }
}
