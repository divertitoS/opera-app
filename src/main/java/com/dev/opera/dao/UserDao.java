package com.dev.opera.dao;

import com.dev.opera.model.User;

import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
