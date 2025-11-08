package com.example.jenkinsdemo.controller;

import com.example.jenkinsdemo.model.Todo;
import com.example.jenkinsdemo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo addTodo(@RequestBody String title) {
        return todoService.addTodo(title);
    }

    @PutMapping("/{id}")
    public void toggleCompleted(@PathVariable Long id) {
        todoService.toggleCompleted(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
