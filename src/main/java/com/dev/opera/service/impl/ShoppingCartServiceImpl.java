package com.dev.opera.service.impl;

import com.dev.opera.dao.ShoppingCartDao;
import com.dev.opera.dao.TicketDao;
import com.dev.opera.lib.Inject;
import com.dev.opera.lib.Service;
import com.dev.opera.model.PerformanceSession;
import com.dev.opera.model.ShoppingCart;
import com.dev.opera.model.Ticket;
import com.dev.opera.model.User;
import com.dev.opera.service.ShoppingCartService;

import java.util.ArrayList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(performanceSession);
        ticket.setUser(user);

        ShoppingCart currentUserCart = shoppingCartDao.getByUser(user);
        currentUserCart.getTickets().add(ticketDao.add(ticket));
        shoppingCartDao.update(currentUserCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartDao.update(shoppingCart);
    }
}
