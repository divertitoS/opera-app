package com.dev.opera.dao.impl;

import com.dev.opera.dao.AbstractDao;
import com.dev.opera.dao.PerformanceSessionDao;
import com.dev.opera.exception.DataProcessingException;
import com.dev.opera.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl
        extends AbstractDao<PerformanceSession>
        implements PerformanceSessionDao {
    public PerformanceSessionDaoImpl(SessionFactory factory) {
        super(factory, PerformanceSession.class);
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<PerformanceSession> getAvailableSessions = session.createQuery(
                    "FROM PerformanceSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date",
                    PerformanceSession.class);
            getAvailableSessions.setParameter("id", performanceId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for performance with id "
                    + performanceId + " and show date " + date + " not found", e);
        }
    }
}
