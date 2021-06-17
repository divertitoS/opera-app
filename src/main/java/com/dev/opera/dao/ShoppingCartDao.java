package com.dev.opera.dao;

import com.dev.opera.model.ShoppingCart;
import com.dev.opera.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
