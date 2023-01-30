package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.Authority;
import com.anhlam.petrang.domain.User;
import com.anhlam.petrang.repository.UserRepository;
import com.anhlam.petrang.security.UserDetailCustom;
import com.anhlam.petrang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).map(UserDetailCustom::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
    }


    public UserDetails loadUserById(Long userId) {
        return userRepository.findUserById(userId).map(UserDetailCustom::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
    }
}
