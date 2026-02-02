package com.andrade.simple_auth2_app.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrade.simple_auth2_app.dto.userLogin.UserLoginRequest;

@RequestMapping("auth")
public class LoginController {

    @PostMapping("/user/login")
    public void loginUser(@Validated @RequestBody UserLoginRequest userLoginRequest ){

    }
    
}
