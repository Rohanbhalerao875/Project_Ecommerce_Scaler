package com.example.userservice1.configs;

import com.example.userservice1.models.Role;
import com.example.userservice1.models.User;
import com.example.userservice1.repos.RoleRepository;
import com.example.userservice1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Create roles if they don't exist
        Role userRole = roleRepository.findByValue("USER")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setValue("USER");
                    return roleRepository.save(role);
                });

        Role adminRole = roleRepository.findByValue("ADMIN")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setValue("ADMIN");
                    return roleRepository.save(role);
                });

        // Create test users if they don't exist
        if (userRepo.findByEmail("user@example.com").isEmpty()) {
            User user = new User();
            user.setName("Test User");
            user.setEmail("user@example.com");
            user.setHashedPassword(passwordEncoder.encode("password"));
            user.setRoles(Arrays.asList(userRole));
            userRepo.save(user);
        }

        if (userRepo.findByEmail("admin@example.com").isEmpty()) {
            User admin = new User();
            admin.setName("Admin User");
            admin.setEmail("admin@example.com");
            admin.setHashedPassword(passwordEncoder.encode("admin"));
            admin.setRoles(Arrays.asList(adminRole, userRole));
            userRepo.save(admin);
        }
    }
} 