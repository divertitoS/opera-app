package com.dev.opera.dao.impl;

import com.dev.opera.dao.AbstractDao;
import com.dev.opera.dao.StageDao;
import com.dev.opera.model.Stage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}
