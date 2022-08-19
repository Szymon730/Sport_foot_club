package com.example.sportclub.services;

import com.example.sportclub.model.database.TrainerExperience;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerExperienceRequest;
import com.example.sportclub.model.responses.TrainerExperienceResponse;

import java.util.List;

public interface TrainerExperienceService {
    void addTrainerToTrainerExperience(List<TrainerExperience> trainerExperiences, TrainerProfile trainerProfile);

    List<TrainerExperience> mapTrainerExperiences(List<TrainerExperienceRequest> trainerExperiences);

    List<TrainerExperienceResponse> mapToTrainerExperiencesResponse(List<TrainerExperience> trainerExperiences);
}
