package com.example.jenkinsdemo.service;

import com.example.jenkinsdemo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    public Todo addTodo(String title) {
        Long id = counter.incrementAndGet();
        Todo todo = new Todo(id, title, false);
        todos.put(id, todo);
        return todo;
    }

    public void toggleCompleted(Long id) {
        Todo todo = todos.get(id);
        if (todo != null) {
            todo.setCompleted(!todo.isCompleted());
        }
    }

    public void deleteTodo(Long id) {
        todos.remove(id);
    }
}
