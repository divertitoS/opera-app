package com.dev.opera.service;

import com.dev.opera.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}
