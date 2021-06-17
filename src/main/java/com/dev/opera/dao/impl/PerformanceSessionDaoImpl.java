package com.dev.opera.dao.impl;

import com.dev.opera.dao.PerformanceSessionDao;
import com.dev.opera.exception.DataProcessingException;
import com.dev.opera.lib.Dao;
import com.dev.opera.model.PerformanceSession;
import com.dev.opera.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Dao
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save current movie session: "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<PerformanceSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> getByIdQuery = session
                    .createQuery("FROM PerformanceSession ps "
                            + "LEFT JOIN FETCH ps.performance "
                            + "LEFT JOIN FETCH ps.stage "
                            + "WHERE ps.id = :id", PerformanceSession.class);
            getByIdQuery.setParameter("id", id);
            return Optional.ofNullable(getByIdQuery.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't take movie session by current ID: " + id, e);
        }
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> findAllMovieSessionQuery = session
                    .createQuery("FROM PerformanceSession ps "
                                    + "LEFT JOIN FETCH ps.performance "
                                    + "LEFT JOIN FETCH ps.stage "
                                    + "WHERE ps.performance.id = :id "
                                    + "AND ps.showTime BETWEEN :startOfDay AND :endOfDay",
                            PerformanceSession.class);
            findAllMovieSessionQuery.setParameter("id", movieId);
            findAllMovieSessionQuery.setParameter("startOfDay", date.atTime(LocalTime.MIDNIGHT));
            findAllMovieSessionQuery.setParameter("endOfDay", date.atTime(LocalTime.MAX));
            return findAllMovieSessionQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't take all of available sessions by "
                    + "current movie ID: " + movieId + ", and current date: " + date, e);
        }
    }
}
