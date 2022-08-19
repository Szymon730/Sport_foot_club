package com.example.sportclub.services;

import com.example.sportclub.model.database.TrainerCertificates;
import com.example.sportclub.model.database.TrainerProfile;
import com.example.sportclub.model.requests.TrainerCertificatesRequest;
import com.example.sportclub.model.responses.TrainerCertificatesResponse;

import java.util.List;

public interface TrainerCertificatesService {
    void addTrainerToTrainerCertificates(List<TrainerCertificates> trainerCertificates, TrainerProfile trainerProfile);

    List<TrainerCertificates> mapTrainerCertificates(List<TrainerCertificatesRequest> trainerCertificatesRequest);

    List<TrainerCertificatesResponse> mapToTrainerCertificatesResponse(List<TrainerCertificates> trainerCertificates);
}
