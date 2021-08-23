package com.foo.sa_ad.dao;

import com.foo.sa_ad.entity.Todo;

import java.util.List;

public interface TodoDao {
    List<Todo> getAllTodos();

    Todo getTodoById(Long id);

    Todo addNewTodo(Todo todo);

    void deleteTodoById(Todo todo);

    Todo changeTodoStatus(Todo todo);
}
