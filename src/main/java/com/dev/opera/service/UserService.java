package com.dev.opera.service;

import com.dev.opera.model.User;

import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
