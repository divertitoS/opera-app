package com.dev.opera.dao;

import com.dev.opera.model.Order;
import com.dev.opera.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
