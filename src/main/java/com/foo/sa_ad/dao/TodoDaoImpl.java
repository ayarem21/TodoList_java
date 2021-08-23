package com.foo.sa_ad.dao;

import com.foo.sa_ad.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao {
    @Autowired
    JdbcOperations jdbcOperations;
    @Override
    public List<Todo> getAllTodos() {
        return jdbcOperations.query("SELECT * FROM TODO",
                (resultSet, i) -> new Todo(resultSet.getLong("id"),
                resultSet.getString("name")));
    }

    @Override
    public ResponseEntity getTodoById(Long id) {
        return ResponseEntity.ok(jdbcOperations.queryForObject("SELECT * FROM TODO WHERE id = ?",
                (resultSet, i) -> new Todo(resultSet.getLong("id"),
                        resultSet.getString("name")), id));
    }

    @Override
    public int addNewTodo(Todo todo) {
        return jdbcOperations.update("INSERT INTO TODO (NAME) VALUES (?);",
                todo.getName());
    }

    @Override
    public void deleteTodoById(Long id) {
        jdbcOperations.update("DELETE FROM TODO WHERE id = ?", id);
    }
}
