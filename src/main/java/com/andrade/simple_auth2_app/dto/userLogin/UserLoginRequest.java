package com.andrade.simple_auth2_app.dto.userLogin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record  UserLoginRequest(@Email String name, @NotBlank String password ) {
    
}
