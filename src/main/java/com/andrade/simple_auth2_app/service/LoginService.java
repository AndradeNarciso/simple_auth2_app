package com.andrade.simple_auth2_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

import com.andrade.simple_auth2_app.dto.userLogin.UserLoginRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {
    @Autowired
    private final JwtEncoder encoder;

    public JwtEncoder encoder (UserLoginRequest userLoginRequest){
        return null;
    }

}
