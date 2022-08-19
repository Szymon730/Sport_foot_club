package com.example.sportclub.services;

import com.example.sportclub.model.requests.TrainerProfileRequest;
import com.example.sportclub.model.responses.TrainerProfileResponse;

public interface TrainerProfileService {
    TrainerProfileResponse addTrainerProfile(TrainerProfileRequest trainerProfileRequest, String name);

    TrainerProfileResponse getTrainerByName(String name);
}
