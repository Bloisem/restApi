package com.example.restApi.model;

import com.example.restApi.entity.UserEntity;
import com.example.restApi.exception.UserNotFoundException;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String username;



    private List<TodoModel> todoList;

    public UserModel() {
    }


    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodoList(entity.getTodoList().stream().map(TodoModel::toModelTodo).collect(Collectors.toList()));
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public List<TodoModel> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoModel> todoList) {
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
