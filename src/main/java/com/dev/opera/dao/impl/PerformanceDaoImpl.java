package com.dev.opera.dao.impl;

import com.dev.opera.dao.AbstractDao;
import com.dev.opera.dao.PerformanceDao;
import com.dev.opera.model.Performance;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
