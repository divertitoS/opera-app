package com.dev.opera.dao;

import com.dev.opera.model.PerformanceSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    Optional<PerformanceSession> get(Long id);

    PerformanceSession add(com.dev.opera.model.PerformanceSession session);
}
