package com.example.sportclub.services;

import com.example.sportclub.model.database.DAOUser;
import com.example.sportclub.model.dto.UserDTO;
import com.example.sportclub.repo.PlayerRepository;
import com.example.sportclub.repo.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserDaoRepository userDaoRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDaoRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(user::getRole));
    }

    public DAOUser save(UserDTO user) {

        DAOUser newUser = new DAOUser();
        newUser.setRole("ROLE_USER");
        newUser.setEmail(user.getUsername());
        playerRepository.findByEmail(user.getUsername())
                .ifPresent(player -> {
                    newUser.setRole("ROLE_PLAYER");
                    newUser.setPlayer(player);
                    player.setUser(newUser);
                });
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDaoRepository.save(newUser);
    }
}