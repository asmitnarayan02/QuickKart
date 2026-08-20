package com.quickkart.quickkart.service;

import com.quickkart.quickkart.dto.AuthResponse;
import com.quickkart.quickkart.dto.LoginRequest;
import com.quickkart.quickkart.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
