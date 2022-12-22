package com.example.restApi.controller;

import com.example.restApi.entity.TodoEntity;
import com.example.restApi.service.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController {
    @Autowired
    private TodoServices todoServices;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
    @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoServices.createTodo(todoEntity,userId));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Todo non è stato creato");

        }

    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoServices.completedTodo(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Todo non è stato aggiornato");

        }
    }


}
