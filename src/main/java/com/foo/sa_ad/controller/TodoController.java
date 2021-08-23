package com.foo.sa_ad.controller;

import com.foo.sa_ad.entity.Todo;
import com.foo.sa_ad.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
       return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
        return todoService.addNewTodo(todo);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}
