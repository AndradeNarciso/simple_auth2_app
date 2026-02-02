package com.andrade.simple_auth2_app.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrade.simple_auth2_app.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User,UUID> {
    Optional<User> findUserByEmail(String email);
    
}
