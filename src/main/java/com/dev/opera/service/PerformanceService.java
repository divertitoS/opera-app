package com.dev.opera.service;

import com.dev.opera.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}
