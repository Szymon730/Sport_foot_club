package com.example.sportclub.repo;

import com.example.sportclub.model.database.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLocationRepository extends JpaRepository<EventLocation, Long> {
}
