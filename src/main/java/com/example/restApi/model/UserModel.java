package com.example.restApi.model;

import com.example.restApi.entity.UserEntity;

import java.util.Optional;


public class UserModel {
    private Long id;
    private String username;


    public static UserModel toModel(Optional<UserEntity> userEntity) {
        UserModel userModel= new UserModel();
        userModel.id = userEntity.get().getId();
        userModel.username= userEntity.get().getUsername();
        return userModel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
