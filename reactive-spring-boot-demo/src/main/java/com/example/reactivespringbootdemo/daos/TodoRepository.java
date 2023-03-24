package com.example.reactivespringbootdemo.daos;

import com.example.reactivespringbootdemo.models.Todo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends ReactiveCrudRepository<Todo, Integer> {
}
