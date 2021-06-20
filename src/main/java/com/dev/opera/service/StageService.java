package com.dev.opera.service;

import com.dev.opera.model.Stage;
import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    Stage get(Long id);

    List<Stage> getAll();
}
