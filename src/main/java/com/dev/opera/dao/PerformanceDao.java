package com.dev.opera.dao;

import com.dev.opera.model.Performance;

import java.util.List;
import java.util.Optional;

public interface PerformanceDao {
    Performance add(Performance performance);

    Optional<Performance> get(Long id);

    List<Performance> getAll();
}
