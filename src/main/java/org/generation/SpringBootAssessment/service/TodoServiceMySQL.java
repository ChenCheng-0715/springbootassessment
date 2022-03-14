package org.generation.SpringBootAssessment.service;


import org.generation.SpringBootAssessment.repository.TodoRepository;
import org.generation.SpringBootAssessment.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceMySQL implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceMySQL(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }


    @Override
    public List<Todo> all() {
        List<Todo> result = new ArrayList<>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }
}
