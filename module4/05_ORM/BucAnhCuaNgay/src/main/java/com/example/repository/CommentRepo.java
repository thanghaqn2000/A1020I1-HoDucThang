package com.example.repository;

import com.example.model.Commen;

import java.util.List;

public interface CommentRepo {
    List<Commen> findAll();
    void create(Commen commen);
    void delete(Commen commen);
    void update(Commen commen);
}
