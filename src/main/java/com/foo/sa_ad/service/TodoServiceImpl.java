package com.foo.sa_ad.service;

import com.foo.sa_ad.dao.TodoDao;
import com.foo.sa_ad.entity.Todo;
import com.foo.sa_ad.exception.NotFoundTodoException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Todo getTodoById(Long id) {
//        try {
            return todoDao.getTodoById(id);
//        } catch (Exception e) {
//            throw new NotFoundTodoException(id);
//        }
    }

    @Override
    public Todo addNewTodo(Todo todo) {
        return  todoDao.addNewTodo(todo);

    }

    @Override
    public void deleteTodoById(Todo todo) {
        try {
            todoDao.deleteTodoById(todo);
        } catch (Exception e) {
            throw new NotFoundTodoException(todo.getId());
        }
    }

    @Override
    public Todo changeTodoStatus(Todo todo) {
        if (todo.getDone()) {
            todo.setDone(false);
        } else {
            todo.setDone(true);
        }
        return todoDao.changeTodoStatus(todo);
    }
}
