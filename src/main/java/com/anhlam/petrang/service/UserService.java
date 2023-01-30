package com.anhlam.petrang.service;

import com.anhlam.petrang.domain.User;

public interface UserService {
    User createUser(String login, String pass);
}
