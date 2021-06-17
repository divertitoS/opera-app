package com.dev.opera.service.impl;

import com.dev.opera.dao.PerformanceSessionDao;
import com.dev.opera.lib.Inject;
import com.dev.opera.lib.Service;
import com.dev.opera.model.PerformanceSession;
import com.dev.opera.service.PerformanceSessionService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    @Inject
    private PerformanceSessionDao sessionDao;

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return sessionDao.add(session);
    }
}
