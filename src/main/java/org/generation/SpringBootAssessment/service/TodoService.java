package org.generation.SpringBootAssessment.service;

import org.generation.SpringBootAssessment.repository.entity.Todo;

import java.util.List;

public interface TodoService {

    // read all item from database
    List<Todo> all();

    // create new item and save into database
    void save(Todo todo);
}
