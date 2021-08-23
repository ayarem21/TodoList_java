package com.foo.sa_ad.dao;

import com.foo.sa_ad.entity.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoDao {
    List<Todo> getAllTodos();

    ResponseEntity<Todo> getTodoById(Long id);

    int addNewTodo(Todo todo);

    void deleteTodoById(Long id);
}
