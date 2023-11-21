package com.alam.demo.service;

import com.alam.demo.domain.dto.UserDTO;

public interface UserService {
    UserDTO createUser(String login, String pass);
}
