package com.example.restApi.controller;

import com.example.restApi.entity.UserEntity;
import com.example.restApi.exception.UserExistException;
import com.example.restApi.exception.UserNotFoundException;
import com.example.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("Utente è registrato");
        } catch (UserExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore di richiesta!");
        }

    }
    @GetMapping("/")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore di richiesta!");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore di richiesta!");
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteOneUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteOneUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore di richiesta");
        }
    }}

