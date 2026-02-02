package com.andrade.simple_auth2_app.dto.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record  UserAdminRequest (@NotBlank String name, @Email String email, @NotBlank String password) {
    
}
