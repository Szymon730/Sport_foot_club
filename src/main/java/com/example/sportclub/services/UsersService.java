package com.example.sportclub.services;

import com.example.sportclub.model.responses.UserResponse;

import java.util.List;

public interface UsersService {

    List<UserResponse> users();

    void changeUserRoleToPlayer(String username);

}
