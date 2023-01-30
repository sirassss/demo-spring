package com.anhlam.petrang.security;

import com.anhlam.petrang.domain.Authority;
import com.anhlam.petrang.repository.AuthorityRepository;
import com.anhlam.petrang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Component
public class AuthProvider implements AuthenticationProvider {
    private static final int ATTEMPTS_LIMIT = 3;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        return null;
    }

    @Override public boolean supports(Class<?> authentication) {
        return true;
    }
}
