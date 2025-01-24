package com.example.userservice1.repos;

import com.example.userservice1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}
