package com.example.restApi.model;

import com.example.restApi.entity.TodoEntity;

import java.util.List;
import java.util.Objects;

public class TodoModel {
    private Long id;
    private String title;
    private Boolean completed;

    public static TodoModel toModelTodo(TodoEntity todoEntity){
        TodoModel model=new TodoModel();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setCompleted(todoEntity.getCompleted());
        return model;
    }

    public TodoModel() {
    }

    public TodoModel(Long id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoModel todoModel = (TodoModel) o;
        return Objects.equals(id, todoModel.id) && Objects.equals(title, todoModel.title) && Objects.equals(completed, todoModel.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completed);
    }
    @Override
    public String toString() {
        return "TodoModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
