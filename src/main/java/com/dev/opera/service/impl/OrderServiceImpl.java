package com.dev.opera.service.impl;

import com.dev.opera.dao.OrderDao;
import com.dev.opera.lib.Inject;
import com.dev.opera.lib.Service;
import com.dev.opera.model.Order;
import com.dev.opera.model.ShoppingCart;
import com.dev.opera.model.User;
import com.dev.opera.service.OrderService;
import com.dev.opera.service.ShoppingCartService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
