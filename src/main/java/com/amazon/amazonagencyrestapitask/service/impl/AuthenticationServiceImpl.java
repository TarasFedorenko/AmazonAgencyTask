package com.amazon.amazonagencyrestapitask.service.impl;

import com.amazon.amazonagencyrestapitask.data.request.SignInRequest;
import com.amazon.amazonagencyrestapitask.data.request.SignUpRequest;
import com.amazon.amazonagencyrestapitask.data.response.JwtAuthenticationResponse;
import com.amazon.amazonagencyrestapitask.entity.user.Role;
import com.amazon.amazonagencyrestapitask.entity.user.User;
import com.amazon.amazonagencyrestapitask.repository.UserRepository;
import com.amazon.amazonagencyrestapitask.service.AuthenticationService;
import com.amazon.amazonagencyrestapitask.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
