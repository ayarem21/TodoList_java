package com.foo.sa_ad.exception;

public class TodoException extends RuntimeException {
    public TodoException() {
        super("SMTH went wrong");
    }
}
