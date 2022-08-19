package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.TrainerEducation;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerEducationRequest;
import com.example.sportclub.model.responses.TrainerEducationResponse;
import com.example.sportclub.repo.TrainerEducationRepository;
import com.example.sportclub.services.TrainerEducationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerEducationServiceImpl implements TrainerEducationService {

    private final TrainerEducationRepository trainerEducationRepository;

    public TrainerEducationServiceImpl(TrainerEducationRepository trainerExperienceRepository) {
        this.trainerEducationRepository = trainerExperienceRepository;
    }

    @Override
    public void addTrainerToTrainerEducations(List<TrainerEducation> trainerEducations, TrainerProfile trainerProfile) {
        //Save TrainerEducations
        trainerEducations.forEach(trainerEducation -> trainerEducation.setTrainerProfile(trainerProfile));
        trainerEducationRepository.saveAll(trainerProfile.getTrainerEducations());
    }

    @Override
    public List<TrainerEducation> mapTrainerEducation(List<TrainerEducationRequest> trainerEducationRequest) {
        return trainerEducationRequest.stream().map(trainerEducationReq -> new TrainerEducation(null,
                trainerEducationReq.getDateFrame(),
                trainerEducationReq.getSchoolName(),
                null)).collect(Collectors.toList());
    }

    @Override
    public List<TrainerEducationResponse> mapToTrainerEducationResponse(List<TrainerEducation> trainerEducations) {
        return trainerEducations.stream().map(trainerEducation ->
                new TrainerEducationResponse(
                        trainerEducation.getDateFrame(),
                        trainerEducation.getSchoolName()
                )).collect(Collectors.toList());
    }
}
