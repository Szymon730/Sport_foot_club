package com.example.sportclub.services.impl;

import com.example.sportclub.model.database.DAOUser;
import com.example.sportclub.model.database.Player;
import com.example.sportclub.model.responses.UserResponse;
import com.example.sportclub.repo.UserDaoRepository;
import com.example.sportclub.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserDaoRepository userDaoRepository;

    @Autowired
    public UsersServiceImpl(UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public List<UserResponse> users() {

        return this.userDaoRepository.findAll().stream()
                .map(daoUser -> new UserResponse(daoUser.getEmail(), daoUser.getRole()
                )).collect(Collectors.toList());

    }

    @Override
    public void changeUserRoleToPlayer(String email) {
        DAOUser user = userDaoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        user.setRole("ROLE_PLAYER");
        Player player = new Player();
        player.setUser(user);
        player.setEmail(user.getEmail());
        user.setPlayer(player);
        userDaoRepository.save(user);
    }
}
