package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan(basePackages = "com.example.todolist.model")
public class TodoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}

