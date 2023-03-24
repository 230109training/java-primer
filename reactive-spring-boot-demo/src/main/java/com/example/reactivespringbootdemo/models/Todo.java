package com.example.reactivespringbootdemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class Todo {

    @Id
    private int id;

    @Column
    private String description;

    @Column
    private boolean completed;

    public Todo() {
    }

    public Todo(int id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && completed == todo.completed && Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, completed);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
