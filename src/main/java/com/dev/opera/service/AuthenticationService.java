package com.dev.opera.service;

import com.dev.opera.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
