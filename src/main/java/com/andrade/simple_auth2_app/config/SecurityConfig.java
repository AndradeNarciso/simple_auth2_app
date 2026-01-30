package com.andrade.simple_auth2_app.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Value("${jwt.prv.key}")
    private  RSAPrivateKey privateKey;

    @Value("${jwt.pub.key}")
    private  RSAPublicKey publicKey;

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        
        return http.csrf(csrf -> csrf.disable()) // test env
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.authorizeHttpRequests(auth -> auth

               // )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }


    @Bean 
    pulic JwtEncoder encode(){
        return 
    }


    @Bean JwtDecoder decoder (){
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }

}
