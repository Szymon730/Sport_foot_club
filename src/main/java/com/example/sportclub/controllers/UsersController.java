package com.example.sportclub.controllers;

import com.example.sportclub.model.responses.UserResponse;
import com.example.sportclub.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(usersService.users());
    }

    @PutMapping("/user/{username}/role/player")
    public ResponseEntity<Void> setUserRoleToPlayer(@PathVariable String username) {
        usersService.changeUserRoleToPlayer(username);
        return ResponseEntity.noContent().build();
    }

}
