package com.dev.opera.dao.impl;

import com.dev.opera.dao.TicketDao;
import com.dev.opera.exception.DataProcessingException;
import com.dev.opera.lib.Dao;
import com.dev.opera.model.Ticket;
import com.dev.opera.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot create ticket ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
