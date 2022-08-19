package com.example.sportclub.services;

import com.example.sportclub.model.requests.AddNewEventLocationRequest;
import com.example.sportclub.model.responses.AvailableEventLocationsResponse;

public interface EventLocationService {


    void addEventLocation(AddNewEventLocationRequest addNewEventLocationRequest);

    AvailableEventLocationsResponse getAvailableEventLocations();
}
