package com.dev.opera.service.impl;

import com.dev.opera.dao.PerformanceDao;
import com.dev.opera.lib.Inject;
import com.dev.opera.lib.Service;
import com.dev.opera.model.Performance;
import com.dev.opera.service.PerformanceService;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Inject
    private PerformanceDao performanceDao;

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).get();
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
