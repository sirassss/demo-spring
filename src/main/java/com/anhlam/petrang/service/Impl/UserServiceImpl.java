package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.Authority;
import com.anhlam.petrang.domain.User;
import com.anhlam.petrang.repository.UserRepository;
import com.anhlam.petrang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(String login, String pass) {
        User u = new User();
        u.setUsername(login);
        u.setPassword(passwordEncoder.encode(pass));
        Authority au = new Authority();
        au.setName("ROLE_USER");
        u.setAuthorities(Set.of(au));
        return userRepository.save(u);
    }
}
