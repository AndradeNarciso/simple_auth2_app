package com.andrade.simple_auth2_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.simple_auth2_app.dto.admin.UserAdminRequest;
import com.andrade.simple_auth2_app.dto.admin.UserAdminResponse;
import com.andrade.simple_auth2_app.dto.regularUser.RegularUserRequest;
import com.andrade.simple_auth2_app.dto.regularUser.RegularUserResponse;
import com.andrade.simple_auth2_app.service.RegisterUsersService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterUser {
    private final RegisterUsersService RegisterUsersService;

    @PostMapping("/admin")
    public ResponseEntity<UserAdminResponse> registerAdim(@Valid @RequestBody UserAdminRequest admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RegisterUsersService.addAdmin(admin));
    }

     @PostMapping("/regular-user")
    public ResponseEntity<RegularUserResponse> registerUser(@Valid @RequestBody RegularUserRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RegisterUsersService.addRegularUser(user));
    }


}
