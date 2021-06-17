package com.dev.opera.dao;

import com.dev.opera.model.Stage;

import java.util.List;
import java.util.Optional;

public interface StageDao {
    Stage add(Stage stage);

    Optional<Stage> get(Long id);

    List<Stage> getAll();
}
