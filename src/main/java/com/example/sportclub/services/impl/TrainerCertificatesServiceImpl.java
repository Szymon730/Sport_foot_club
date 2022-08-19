package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.TrainerCertificates;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerCertificatesRequest;
import com.example.sportclub.model.responses.TrainerCertificatesResponse;
import com.example.sportclub.repo.TrainerCertificatesRepository;
import com.example.sportclub.services.TrainerCertificatesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerCertificatesServiceImpl implements TrainerCertificatesService {

    private final TrainerCertificatesRepository trainerCertificatesRepository;

    public TrainerCertificatesServiceImpl(final TrainerCertificatesRepository trainerCertificatesRepository) {
        this.trainerCertificatesRepository = trainerCertificatesRepository;
    }

    @Override
    public void addTrainerToTrainerCertificates(List<TrainerCertificates> trainerCertificates, TrainerProfile trainerProfile) {
        //Save TrainerCertificates
        trainerCertificates.forEach(trainerCertificate -> trainerCertificate.setTrainerProfile(trainerProfile));
        trainerCertificatesRepository.saveAll(trainerProfile.getTrainerCertificates());
    }

    @Override
    public List<TrainerCertificates> mapTrainerCertificates(List<TrainerCertificatesRequest> trainerCertificatesRequest) {
        return trainerCertificatesRequest.stream().map(trainerCertificatesReq -> new TrainerCertificates(null,
                trainerCertificatesReq.getDescription(),
                null)).collect(Collectors.toList());
    }

    @Override
    public List<TrainerCertificatesResponse> mapToTrainerCertificatesResponse(List<TrainerCertificates> trainerCertificates) {
        return trainerCertificates.stream().map(trainerCert -> new TrainerCertificatesResponse(
                trainerCert.getDescription())).collect(Collectors.toList());
    }
}
