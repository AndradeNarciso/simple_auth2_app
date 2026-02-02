package com.andrade.simple_auth2_app.service;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andrade.simple_auth2_app.domain.User;
import com.andrade.simple_auth2_app.dto.admin.UserAdminRequest;
import com.andrade.simple_auth2_app.enums.Role;
import com.andrade.simple_auth2_app.exception.RoleException;
import com.andrade.simple_auth2_app.repository.RoleRepository;
import com.andrade.simple_auth2_app.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterUsers {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void addAdmin(UserAdminRequest userAdmin){

        var role= roleRepository.findByName(Role.ADMIN.getValue());

        User user= User.builder()
        .name(userAdmin.name())
        .passwords(passwordEncoder.encode(userAdmin.password()).toString())
        .email(userAdmin.email())
        .roles(Set.of(role))
        .build();

        userRepository.save(user);

    }
}
