package com.foo.sa_ad.exception;

public class NotFoundTodoException extends RuntimeException {
    public NotFoundTodoException(Long id) {
        super("Could not find Todo with id " + id);
    }
}
