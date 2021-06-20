package com.dev.opera.service.impl;

import com.dev.opera.model.Role;
import com.dev.opera.model.User;
import com.dev.opera.service.AuthenticationService;
import com.dev.opera.service.RoleService;
import com.dev.opera.service.ShoppingCartService;
import com.dev.opera.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role userRole = roleService.getRoleByName(Role.RoleName.USER);
        user.setRoles(Set.of(userRole));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
