package com.example.reactivespringbootdemo.services;

import com.example.reactivespringbootdemo.daos.TodoRepository;
import com.example.reactivespringbootdemo.models.Todo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Mono<List<String>> getTodoDescriptions() {
        Flux<Todo> todoFlux = todoRepository.findAll();

        Flux<String> descriptionFlux = todoFlux.map((todo) -> todo.getDescription());

        return descriptionFlux.collect(Collectors.toList());
    }

}
