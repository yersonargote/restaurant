package com.yersonargote.restaurant.auth.service;

import com.yersonargote.restaurant.auth.domain.Role;
import com.yersonargote.restaurant.auth.domain.User;
import com.yersonargote.restaurant.auth.dto.AuthenticationRequest;
import com.yersonargote.restaurant.auth.dto.AuthenticationResponse;
import com.yersonargote.restaurant.auth.dto.RegisterRequest;
import com.yersonargote.restaurant.auth.repository.UserRepository;
import com.yersonargote.restaurant.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(), request.password()));
        // var user = (com.yersonargote.restaurant.auth.domain.User) authentication.getPrincipal();
        var user = userRepository
                .findByUsername(request.username())
                .orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
