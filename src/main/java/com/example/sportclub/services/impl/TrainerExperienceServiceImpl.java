package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.TrainerExperience;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerExperienceRequest;
import com.example.sportclub.model.responses.TrainerExperienceResponse;
import com.example.sportclub.repo.TrainerExperienceRepository;
import com.example.sportclub.services.TrainerExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerExperienceServiceImpl implements TrainerExperienceService {

    private final TrainerExperienceRepository trainerExperienceRepository;

    public TrainerExperienceServiceImpl(TrainerExperienceRepository trainerExperienceRepository) {
        this.trainerExperienceRepository = trainerExperienceRepository;
    }

    @Override
    public void addTrainerToTrainerExperience(List<TrainerExperience> trainerExperiences, TrainerProfile trainerProfile) {
        //Save TrainerExperiences
        trainerExperiences.forEach(trainerExperience -> trainerExperience.setTrainerProfile(trainerProfile));
        trainerExperienceRepository.saveAll(trainerProfile.getTrainerExperiences());
    }

    @Override
    public List<TrainerExperience> mapTrainerExperiences(List<TrainerExperienceRequest> trainerExperiences) {
        return trainerExperiences.stream().map(trainerExperienceReq -> new TrainerExperience(null,
                trainerExperienceReq.getDateFrame(),
                trainerExperienceReq.getWorkLocation(),
                trainerExperienceReq.getDescription(),
                null)).collect(Collectors.toList());
    }

    @Override
    public List<TrainerExperienceResponse> mapToTrainerExperiencesResponse(List<TrainerExperience> trainerExperiences) {
        return trainerExperiences.stream().map(trainerExperience -> new TrainerExperienceResponse(
                trainerExperience.getDateFrame(),
                trainerExperience.getWorkLocation(),
                trainerExperience.getDescription())).collect(Collectors.toList());
    }
}
