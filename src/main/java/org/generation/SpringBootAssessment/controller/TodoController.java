package org.generation.SpringBootAssessment.controller;


import org.generation.SpringBootAssessment.controller.dto.TodoDTO;
import org.generation.SpringBootAssessment.repository.entity.Todo;
import org.generation.SpringBootAssessment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }


    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Todo> getAll() {
        return todoService.all();
    }


    @CrossOrigin
    @PostMapping("/add")
    public void save(@RequestParam(name="title") String title,
                     @RequestParam(name="description") String description,
                     @RequestParam(name="date") Date date) throws IOException {
        TodoDTO todoDTO = new TodoDTO(title, description, date);
        todoService.save(new Todo(todoDTO));
    }
}
