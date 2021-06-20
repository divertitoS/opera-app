package com.dev.opera.service;

import com.dev.opera.model.PerformanceSession;
import com.dev.opera.model.ShoppingCart;
import com.dev.opera.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
