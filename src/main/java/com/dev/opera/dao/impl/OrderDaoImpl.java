package com.dev.opera.dao.impl;

import com.dev.opera.dao.OrderDao;
import com.dev.opera.exception.DataProcessingException;
import com.dev.opera.lib.Dao;
import com.dev.opera.model.Order;
import com.dev.opera.model.User;
import com.dev.opera.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@Dao
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save order into DB: " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Order o "
                    + "INNER JOIN FETCH o.tickets "
                    + "WHERE o.user = :user "
                    + "ORDER BY o.orderDate", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        }
    }
}
