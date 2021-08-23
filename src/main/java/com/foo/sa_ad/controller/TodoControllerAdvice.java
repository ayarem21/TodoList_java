package com.foo.sa_ad.controller;

import com.foo.sa_ad.exception.NotFoundTodoException;
import com.foo.sa_ad.exception.TodoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundTodoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String todoNotFoundHandler(NotFoundTodoException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TodoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String todoExceptionHandler(TodoException e) {
        return e.getMessage();
    }
}
