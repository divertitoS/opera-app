package com.dev.opera.security;

import com.dev.opera.exception.AuthenticationException;
import com.dev.opera.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
