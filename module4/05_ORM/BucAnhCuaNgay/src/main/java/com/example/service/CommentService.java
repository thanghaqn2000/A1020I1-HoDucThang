package com.example.service;

import com.example.model.Commen;

import java.util.List;

public interface CommentService {
    List<Commen> findAll();
    void create(Commen commen);
    void delete(Commen commen);
    void update(Commen commen);
}
