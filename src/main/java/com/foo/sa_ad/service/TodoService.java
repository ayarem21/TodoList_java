package com.foo.sa_ad.service;

import com.foo.sa_ad.entity.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    ResponseEntity<Todo> getTodoById(Long id);
    ResponseEntity<String> addNewTodo(Todo todo);
    void deleteTodoById(Long id);
}
