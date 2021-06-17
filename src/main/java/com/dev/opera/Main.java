package com.dev.opera;

import com.dev.opera.lib.Injector;
import com.dev.opera.model.*;
import com.dev.opera.security.AuthenticationService;
import com.dev.opera.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("com.dev.opera");
    private static final PerformanceSessionService performanceSessionService
            = (PerformanceSessionService) injector.getInstance(PerformanceSessionService.class);
    private static final PerformanceService performanceService
            = (PerformanceService) injector.getInstance(PerformanceService.class);
    private static final StageService stageService
            = (StageService) injector.getInstance(StageService.class);
    private static final OrderService orderService
            = (OrderService) injector.getInstance(OrderService.class);
    private static final ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);

    public static void main(String[] args) {
        Performance fastAndFurious = new Performance("L'Orfeo");
        fastAndFurious.setDescription("L'Orfeo is emotional, melancholy and transcendent");
        performanceService.add(fastAndFurious);
        System.out.println(performanceService.get(fastAndFurious.getId()));
        performanceService.getAll().forEach(System.out::println);

        Stage firstCinemaHall = new Stage();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first stage with capacity 100");

        Stage secondCinemaHall = new Stage();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second stage with capacity 200");

        stageService.add(firstCinemaHall);
        stageService.add(secondCinemaHall);

        System.out.println(stageService.getAll());
        System.out.println(stageService.get(firstCinemaHall.getId()));

        PerformanceSession tomorrowMovieSession = new PerformanceSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        PerformanceSession yesterdayMovieSession = new PerformanceSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        performanceSessionService.add(tomorrowMovieSession);
        performanceSessionService.add(yesterdayMovieSession);

        System.out.println(performanceSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(performanceSessionService.findAvailableSessions(
                        fastAndFurious.getId(), LocalDate.now()));

        User bohdan = new User();
        bohdan.setEmail("bohdan123@gmail.com");
        bohdan.setPassword("123");

        User registeredBohdan = authenticationService.register(bohdan.getEmail(),
                bohdan.getPassword());
        System.out.println(registeredBohdan);

        shoppingCartService.addSession(tomorrowMovieSession, registeredBohdan);
        ShoppingCart bohdanCart = shoppingCartService.getByUser(registeredBohdan);
        bohdanCart.setUser(registeredBohdan);
        for (Ticket ticket : bohdanCart.getTickets()) {
            ticket.setUser(registeredBohdan);
        }
        System.out.println(bohdanCart);
        System.out.println(orderService.completeOrder(bohdanCart));

        List<Order> ordersHistory = orderService.getOrdersHistory(registeredBohdan);
        for (Order order : ordersHistory) {
            order.setUser(registeredBohdan);
            for (Ticket ticket : order.getTickets()) {
                ticket.setMovieSession(tomorrowMovieSession);
                ticket.setUser(registeredBohdan);
            }
        }
        System.out.println(ordersHistory);
    }
}
