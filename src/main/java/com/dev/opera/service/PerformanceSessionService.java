package com.dev.opera.service;

import com.dev.opera.model.PerformanceSession;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession get(Long id);

    PerformanceSession add(PerformanceSession session);
}
