package com.example.sportclub.controllers;


import com.example.sportclub.model.requests.AddNewEventLocationRequest;
import com.example.sportclub.model.responses.AvailableEventLocationsResponse;
import com.example.sportclub.services.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventLocationController {

    private final EventLocationService eventLocationService;

    @Autowired
    public EventLocationController(final EventLocationService eventLocationService) {
        this.eventLocationService = eventLocationService;
    }

    @GetMapping("/eventLocations")
    public ResponseEntity<AvailableEventLocationsResponse> availableEventLocations() {
        return ResponseEntity.ok(eventLocationService.getAvailableEventLocations());
    }

    @PostMapping("/createNewEventPlace")
    public ResponseEntity<Void> addNewPlayer(@RequestBody AddNewEventLocationRequest addNewEventLocationRequest) {
        eventLocationService.addEventLocation(addNewEventLocationRequest);
        return ResponseEntity.noContent().build();
    }

}
