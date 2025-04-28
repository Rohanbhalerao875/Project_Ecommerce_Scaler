package com.example.userservice1.security.services;

import com.example.userservice1.models.User;
import com.example.userservice1.repos.UserRepo;
import com.example.userservice1.models.CustomUserDetails;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepository;

    public CustomUserDetailsService() {}

    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepo getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + username + " doesn't exist");
        }
        return new CustomUserDetails(optionalUser.get());
    }
}
