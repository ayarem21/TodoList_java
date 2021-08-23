package com.foo.sa_ad.entity;


import javax.persistence.*;

public class Todo {
    private Long id;
    private String name;

    public Todo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
