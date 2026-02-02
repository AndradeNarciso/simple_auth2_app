package com.andrade.simple_auth2_app.dto.regularUser;

import lombok.Builder;

@Builder
public record RegularUserResponse(String email, String password) {

}
