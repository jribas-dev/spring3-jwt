package com.b3.authjwt.service;

import com.b3.authjwt.dto.AuthRequest;

public interface AuthService {
    String authenticate(AuthRequest authRequest);
}
