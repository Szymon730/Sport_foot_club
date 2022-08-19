package com.example.sportclub.controllers;

import com.example.sportclub.model.requests.TrainerProfileRequest;
import com.example.sportclub.model.responses.TrainerProfileResponse;
import com.example.sportclub.services.TrainerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TrainerProfileController {

    private final TrainerProfileService trainerProfileService;

    public TrainerProfileController(final TrainerProfileService trainerProfileService) {
        this.trainerProfileService = trainerProfileService;
    }

    @GetMapping("/trainer/profile")
    public ResponseEntity<TrainerProfileResponse> getTrainerById(Principal principal) {
        TrainerProfileResponse trainerProfileResponse = trainerProfileService.getTrainerByName(principal.getName());
        return ResponseEntity.ok(trainerProfileResponse);
    }

    @PostMapping("/trainer/profile")
    public ResponseEntity<TrainerProfileResponse> createNewTrainerProfile(@RequestBody TrainerProfileRequest trainerProfileRequest, Principal principal) {

        TrainerProfileResponse trainerProfileResponse = trainerProfileService.addTrainerProfile(trainerProfileRequest, principal.getName());

        return ResponseEntity.ok(trainerProfileResponse);
    }

}
