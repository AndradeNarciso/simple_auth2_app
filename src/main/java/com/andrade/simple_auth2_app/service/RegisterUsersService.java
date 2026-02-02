package com.andrade.simple_auth2_app.service;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andrade.simple_auth2_app.domain.User;
import com.andrade.simple_auth2_app.dto.admin.UserAdminRequest;
import com.andrade.simple_auth2_app.dto.admin.UserAdminResponse;
import com.andrade.simple_auth2_app.dto.regularUser.RegularUserRequest;
import com.andrade.simple_auth2_app.dto.regularUser.RegularUserResponse;
import com.andrade.simple_auth2_app.enums.Role;
import com.andrade.simple_auth2_app.repository.RoleRepository;
import com.andrade.simple_auth2_app.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterUsersService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    public UserAdminResponse addAdmin(UserAdminRequest userAdmin) {

        var role = roleRepository.findByName(Role.ADMIN.getValue());

        User user = User.builder()
                .name(userAdmin.name())
                .passwords(passwordEncoder.encode(userAdmin.password()).toString())
                .email(userAdmin.email())
                .roles(Set.of(role))
                .build();

        userRepository.save(user);

        return UserAdminResponse.builder().email(user.getEmail()).password(userAdmin.password()).build();

    }

    @Transactional(rollbackOn = Exception.class)
    public RegularUserResponse addRegularUser(RegularUserRequest RegularUserRequest) {

        var role = roleRepository.findByName(Role.REGULAR.getValue());

        User user = User.builder()
                .name(RegularUserRequest.name())
                .passwords(passwordEncoder.encode(RegularUserRequest.password()).toString())
                .email(RegularUserRequest.email())
                .roles(Set.of(role))
                .build();

        userRepository.save(user);

        return RegularUserResponse.builder().email(user.getEmail()).password(RegularUserRequest.password()).build();

    }

}
