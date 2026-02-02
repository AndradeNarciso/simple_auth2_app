package com.andrade.simple_auth2_app.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrade.simple_auth2_app.dto.userLogin.UserLoginRequest;

@RequestMapping("auth")
public class LoginController {

    @PostMapping("/user")
    public void loginUser(@Validated UserLoginRequest userLoginRequest ){

    }
    
}
