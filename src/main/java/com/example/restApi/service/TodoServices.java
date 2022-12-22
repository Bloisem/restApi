package com.example.restApi.service;

import com.example.restApi.entity.TodoEntity;
import com.example.restApi.entity.UserEntity;
import com.example.restApi.model.TodoModel;
import com.example.restApi.repository.TodoRepository;
import com.example.restApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServices {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public TodoModel createTodo(TodoEntity todo, Long userId){
        UserEntity userEntity = userRepository.findById(userId).get();
        todo.setUser(userEntity);
        return TodoModel.toModelTodo(todoRepository.save(todo));
    }
    public TodoModel completedTodo(Long todoId){
    TodoEntity todoEntity= todoRepository.findById(todoId).get();
    todoEntity.setCompleted(!todoEntity.getCompleted());
    return TodoModel.toModelTodo(todoRepository.save(todoEntity));
    }
}
