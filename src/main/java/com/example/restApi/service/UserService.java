package com.example.restApi.service;

import com.example.restApi.exception.UserNotFoundException;
import com.example.restApi.model.UserModel;
import com.example.restApi.entity.UserEntity;
import com.example.restApi.exception.UserExistException;
import com.example.restApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserExistException("Utente con username " +user.getUsername()+ " già esiste!");
        }
        else{
            userRepository.save(user);
            return user;
        }
    }
    public List<UserModel> getAll() throws UserNotFoundException {
        List<UserEntity> userEntityList= (List<UserEntity>) userRepository.findAll();
        List<UserModel> userModelList = new ArrayList<>();
        for(UserEntity userEntity:userEntityList){
            userModelList.add(UserModel.toModel(userEntity));
        }
        return userModelList;
    }
    public UserModel getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Utente non è trovato!");
        }
        return UserModel.toModel(user);
    }

    public Long deleteOneUser(Long id) throws UserNotFoundException {
        userRepository.deleteById(id);
        return id;
    }
}
