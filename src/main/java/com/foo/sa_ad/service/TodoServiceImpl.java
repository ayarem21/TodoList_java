package com.foo.sa_ad.service;

import com.foo.sa_ad.dao.TodoDao;
import com.foo.sa_ad.entity.Todo;
import com.foo.sa_ad.exception.NotFoundTodoException;
import com.foo.sa_ad.exception.TodoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoDao todoDao;

    @Override
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    @Override
    public ResponseEntity<Todo> getTodoById(Long id) {
        try {
            return todoDao.getTodoById(id);
        } catch (Exception e) {
            throw new NotFoundTodoException(id);
        }
    }

    @Override
    public ResponseEntity<String> addNewTodo(Todo todo) {
        if(todoDao.addNewTodo(todo) == 1) {
            return ResponseEntity.ok("Todo created");
        } else {
            throw new TodoException();
        }
    }

    @Override
    public void deleteTodoById(Long id) {
        try {
            todoDao.deleteTodoById(id);
        } catch (Exception e) {
            throw new NotFoundTodoException(id);
        }
    }
}
