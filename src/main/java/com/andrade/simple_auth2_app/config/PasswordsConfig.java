package com.andrade.simple_auth2_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordsConfig {

    @Bean
    public BCryptPasswordEncoder encodePasswords() {
        return new BCryptPasswordEncoder();
    }
}
