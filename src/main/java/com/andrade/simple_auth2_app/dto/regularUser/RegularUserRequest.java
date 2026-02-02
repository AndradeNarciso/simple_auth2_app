package com.andrade.simple_auth2_app.dto.regularUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegularUserRequest (@NotBlank String name, @Email String email, @NotBlank String password) {
    
}
