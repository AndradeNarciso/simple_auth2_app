package com.andrade.simple_auth2_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andrade.simple_auth2_app.domain.User;
import com.andrade.simple_auth2_app.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<User> getAllService() {
        return userRepository.findAll();
    }

}
