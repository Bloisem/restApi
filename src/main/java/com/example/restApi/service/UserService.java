package com.example.restApi.service;

import com.example.restApi.entity.UserEntity;
import com.example.restApi.exception.UserExistException;
import com.example.restApi.exception.UserNotFound;
import com.example.restApi.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List <UserEntity>getAll(){
        return (List<UserEntity>) userRepository.findAll() ;
    }


}
