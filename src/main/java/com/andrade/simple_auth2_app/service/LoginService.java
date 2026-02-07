package com.andrade.simple_auth2_app.service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.andrade.simple_auth2_app.domain.User;
import com.andrade.simple_auth2_app.dto.userLogin.UserLoginRequest;
import com.andrade.simple_auth2_app.dto.userLogin.UserLoginResponse;
import com.andrade.simple_auth2_app.repository.UserRepository;
import com.andrade.simple_auth2_app.exception.BadCredencialException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private final JwtEncoder encoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoderPasswords;
    private final JwtEncoder jwtEncoder;

    public UserLoginResponse login(UserLoginRequest userLoginRequest) throws BadCredencialException {
        User user = userRepository.findUserByEmail(userLoginRequest.email())
                .orElseThrow(() -> new BadCredencialException("Invalid Credencial"));

        if (!encoderPasswords.matches(userLoginRequest.password(), user.getPasswords())) {
            throw new BadCredencialException("Invalid Credencial");
        }

        var scope= user.getRoles().stream().map(role -> role.getName()).collect(Collectors.joining(" "));
      
        Instant expireAt = Instant.now().plusSeconds(300);
        var claim = JwtClaimsSet.builder()
                .issuer("Andrade")
                .subject(user.getId().toString())
                .expiresAt(expireAt)
                .issuedAt(Instant.now())
                .claim("scope", scope)
                .build();

        var jwt = jwtEncoder.encode(JwtEncoderParameters.from(claim));

        return UserLoginResponse.builder().token(jwt.getTokenValue()).expireIn(expireAt).build();
    }

}
