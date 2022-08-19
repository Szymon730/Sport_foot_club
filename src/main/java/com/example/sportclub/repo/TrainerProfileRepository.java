package com.example.sportclub.repo;

import com.example.sportclub.model.database.TrainerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerProfileRepository extends JpaRepository<TrainerProfile, Long> {
}
