package com.andrade.simple_auth2_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.simple_auth2_app.dto.admin.UserAdminRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register ")
public class RegisterUser {


    @PostMapping("/admin")
    public void registerAdim(@Valid @RequestBody UserAdminRequest admin){
        
    }
    
}
