package com.example.restApi.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private Boolean completed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    }

