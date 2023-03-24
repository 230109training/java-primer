package com.example.reactivespringbootdemo;

import com.example.reactivespringbootdemo.daos.TodoRepository;
import com.example.reactivespringbootdemo.models.Todo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReactiveSpringBootDemoApplication implements ApplicationRunner {

	private TodoRepository todoRepository;

	public ReactiveSpringBootDemoApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringBootDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Flux<Todo> todosFlux =  todoRepository.findAll();
		// Flux is a multi-value stream of objects
		// When we call .findAll(), we immediately are returned the Flux object
		// And when we want to extract data from the Flux object, it will come back at some point
		// in the future
		// In this way, Flux is very similar to promises
		todosFlux.subscribe((todo) -> System.out.println(todo));
		// .subscribe is similar to .then() when we're dealing with Promises in JavaScript
		// .subscribe allows us to register a callback function that will be called in the future whenever
		// the I/O operation is complete. In the meanwhile, our thread is not blocked and can move on and
		// execute other code
		System.out.println("Hello World");
		// -> Hello World will print out before the Todos are printed out
		// The reason for that is that we are not following a synchronous blocking model anymore
		// We are now using asynchronous programming
		// Our thread is free to execute other tasks, such as printing out Hello World while our
		// OS is retrieving data from the database
		// The OS will inform the application when the retrieval process is finished, which allows
		// for the application to go back to the registered callback function and execute whatever
		// logic it needs to

	}
}
