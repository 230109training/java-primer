package com.example.reactivespringbootdemo.controllers;

import com.example.reactivespringbootdemo.models.Todo;
import com.example.reactivespringbootdemo.services.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path="/todos")
    public Mono<List<String>> getAllTodos() {
        // Flux<Todo> will get returned to Netty
        // and then our thread will be able to go and serve other HTTP requests while
        // we are waiting for the long running IO operation to complete
        // When the IO operation is complete, then Netty will be able to take the data from the Flux
        // object that we gave to it, and then it will send the response to the User
        return todoService.getTodoDescriptions();
    }

}
