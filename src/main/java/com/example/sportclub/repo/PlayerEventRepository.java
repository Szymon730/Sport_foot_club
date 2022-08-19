package com.example.sportclub.repo;

import com.example.sportclub.model.database.Event;
import com.example.sportclub.model.database.PlayerEvent;
import com.example.sportclub.model.database.key.PlayerEventKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerEventRepository extends JpaRepository<PlayerEvent, PlayerEventKey> {

    Optional<PlayerEvent> findByEvent_EventCodeAndPlayer_Email(UUID eventCode, String userEmail);
}
