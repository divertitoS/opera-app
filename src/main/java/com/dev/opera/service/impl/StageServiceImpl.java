package com.dev.opera.service.impl;

import com.dev.opera.dao.StageDao;
import com.dev.opera.lib.Inject;
import com.dev.opera.lib.Service;
import com.dev.opera.model.Stage;
import com.dev.opera.service.StageService;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {
    @Inject
    private StageDao stageDao;

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id).get();
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }
}
