package com.amazon.amazonagencyrestapitask.service;

import com.amazon.amazonagencyrestapitask.data.request.SignInRequest;
import com.amazon.amazonagencyrestapitask.data.request.SignUpRequest;
import com.amazon.amazonagencyrestapitask.data.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}