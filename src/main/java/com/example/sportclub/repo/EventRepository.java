package com.example.sportclub.repo;

import com.example.sportclub.model.database.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDateTimeAfter(LocalDateTime dateTime);

    List<Event> findByDateTimeAfterAndPlayersContains(LocalDateTime dateTime, String playerEmail);


    Optional<Event> findByEventCode(UUID eventCode);
}
