package com.foo.sa_ad.entity;


import javax.persistence.*;

@Entity
@Table(name = "TODO")
public class Todo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DONE")
    private Boolean isDone;

    public Todo(Long id, String name, Boolean isDone) {
        this.id = id;
        this.name = name;
        this.isDone = isDone;
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

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
