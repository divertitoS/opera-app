package com.dev.opera.service;

import com.dev.opera.model.Order;
import com.dev.opera.model.ShoppingCart;
import com.dev.opera.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
