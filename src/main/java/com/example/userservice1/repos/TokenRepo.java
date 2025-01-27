package com.example.userservice1.repos;

import com.example.userservice1.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {
    Optional<Token> findByValueAndDeletedAndExpiryAtGreaterThan(String token, boolean isDeleted, long expiryTime);

}
