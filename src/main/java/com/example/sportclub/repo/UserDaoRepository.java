package com.example.sportclub.repo;

import com.example.sportclub.model.database.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDaoRepository extends JpaRepository<DAOUser, Integer> {
    Optional<DAOUser> findByEmail(String email);
}