package com.andrade.simple_auth2_app.dto.admin;

import lombok.Builder;

@Builder
public record  UserAdminResponse(String email, String password) {
    
}
