package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.DAOUser;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerProfileRequest;
import com.example.sportclub.model.responses.TrainerProfileResponse;
import com.example.sportclub.repo.TrainerProfileRepository;
import com.example.sportclub.repo.UserDaoRepository;
import com.example.sportclub.services.TrainerCertificatesService;
import com.example.sportclub.services.TrainerEducationService;
import com.example.sportclub.services.TrainerExperienceService;
import com.example.sportclub.services.TrainerProfileService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerProfileServiceImpl implements TrainerProfileService {


    private final TrainerProfileRepository trainerProfileRepository;
    private final TrainerExperienceService trainerExperienceService;
    private final TrainerEducationService trainerEducationService;
    private final TrainerCertificatesService trainerCertificatesService;
    private final UserDaoRepository userDaoRepository;

    public TrainerProfileServiceImpl(TrainerProfileRepository trainerProfileRepository,
                                     TrainerExperienceService trainerExperienceService,
                                     TrainerEducationService trainerEducationService,
                                     TrainerCertificatesService trainerCertificatesService, UserDaoRepository userDaoRepository) {

        this.trainerProfileRepository = trainerProfileRepository;
        this.trainerExperienceService = trainerExperienceService;
        this.trainerEducationService = trainerEducationService;
        this.trainerCertificatesService = trainerCertificatesService;
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public TrainerProfileResponse addTrainerProfile(TrainerProfileRequest trainerProfileRequest, String email) {

        DAOUser user = userDaoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        TrainerProfile savedTrainer = trainerProfileRepository.save(this.mapTrainerProfile(trainerProfileRequest, user));

        trainerExperienceService.addTrainerToTrainerExperience(savedTrainer.getTrainerExperiences(), savedTrainer);
        trainerEducationService.addTrainerToTrainerEducations(savedTrainer.getTrainerEducations(), savedTrainer);
        trainerCertificatesService.addTrainerToTrainerCertificates(savedTrainer.getTrainerCertificates(), savedTrainer);

        return mapTrainerProfileToTrainerProfileResponse(savedTrainer);
    }

    @Override
    public TrainerProfileResponse getTrainerByName(String email) {
        DAOUser byUsername = userDaoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return this.mapTrainerProfileToTrainerProfileResponse(byUsername.getTrainerProfile());
    }

    private TrainerProfile mapTrainerProfile(TrainerProfileRequest trainerProfileRequest, DAOUser daoUser) {
        return Optional.of(trainerProfileRequest).map(trainerProfileReq -> {
                    TrainerProfile trainerProfile = new TrainerProfile(null,
                            trainerProfileReq.getName(),
                            trainerProfileReq.getLastName(),
                            trainerProfileReq.getAddress(),
                            trainerProfileReq.getCity(),
                            trainerProfileReq.getZipCode(),
                            trainerProfileReq.getProvince(),
                            trainerExperienceService.mapTrainerExperiences(trainerProfileReq.getTrainerExperiences()),
                            trainerEducationService.mapTrainerEducation(trainerProfileReq.getTrainerEducations()),
                            trainerCertificatesService.mapTrainerCertificates(trainerProfileReq.getTrainerCertificates()),
                            daoUser);
                    daoUser.setTrainerProfile(trainerProfile);
                    return trainerProfile;
                }
        ).get();
    }

    private TrainerProfileResponse mapTrainerProfileToTrainerProfileResponse(TrainerProfile trainerProfile) {
        return Optional.ofNullable(trainerProfile)
                .map(trainerProfile1 -> new TrainerProfileResponse(
                        trainerProfile.getName(),
                        trainerProfile.getLastName(),
                        trainerProfile.getAddress(),
                        trainerProfile.getCity(),
                        trainerProfile.getZipCode(),
                        trainerProfile.getProvince(),
                        trainerExperienceService.mapToTrainerExperiencesResponse(trainerProfile.getTrainerExperiences()),
                        trainerEducationService.mapToTrainerEducationResponse(trainerProfile.getTrainerEducations()),
                        trainerCertificatesService.mapToTrainerCertificatesResponse(trainerProfile.getTrainerCertificates())))
                .orElse(null);
    }

}
