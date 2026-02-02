package com.andrade.simple_auth2_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.simple_auth2_app.dto.userLogin.UserLoginRequest;
import com.andrade.simple_auth2_app.dto.userLogin.UserLoginResponse;
import com.andrade.simple_auth2_app.exception.BadCredencialException;
import com.andrade.simple_auth2_app.service.LoginService;

import lombok.AllArgsConstructor;

@RequestMapping("auth")
@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/user/login")
    public ResponseEntity<UserLoginResponse> loginUser(@Validated @RequestBody UserLoginRequest userLoginRequest)
            throws BadCredencialException {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(userLoginRequest));
    }

}
