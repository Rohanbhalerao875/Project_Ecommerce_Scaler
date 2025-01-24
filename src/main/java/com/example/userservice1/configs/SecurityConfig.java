package com.example.userservice1.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


    @Configuration
    @EnableWebSecurity public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())  // CSRF protection enabled (consider disabling for APIs if necessary)
                    .httpBasic(Customizer.withDefaults())  // Enables HTTP Basic authentication (optional)
                    .formLogin(Customizer.withDefaults())  // Enables form-based login (optional)
                    .authorizeHttpRequests(authorize -> authorize
                            .anyRequest().permitAll()  // Allow all requests without authentication
                    );


            return http.build();
        }

    }



