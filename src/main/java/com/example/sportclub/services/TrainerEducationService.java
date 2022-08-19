package com.example.sportclub.services;

import com.example.sportclub.model.database.TrainerEducation;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerEducationRequest;
import com.example.sportclub.model.responses.TrainerEducationResponse;

import java.util.List;

public interface TrainerEducationService {
    void addTrainerToTrainerEducations(List<TrainerEducation> trainerEducations, TrainerProfile trainerProfile);

    List<TrainerEducation> mapTrainerEducation(List<TrainerEducationRequest> trainerEducationRequest);

    List<TrainerEducationResponse> mapToTrainerEducationResponse(List<TrainerEducation> trainerEducations);
}
