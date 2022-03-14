package org.generation.SpringBootAssessment.repository;

import org.generation.SpringBootAssessment.repository.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
