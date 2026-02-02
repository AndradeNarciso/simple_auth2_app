package com.andrade.simple_auth2_app.dto.userLogin;

import java.time.Instant;

import lombok.Builder;

@Builder
public record UserLoginResponse(String token, Instant expireIn) {

}
