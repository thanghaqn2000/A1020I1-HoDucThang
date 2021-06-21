package com.example.service;

import com.example.model.Commen;
import com.example.repository.CommentRepo;
import com.example.repository.CommentRepoImpl;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    CommentRepo commentRepo=new CommentRepoImpl();
    @Override
    public List<Commen> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public void create(Commen commen) {
            commentRepo.create(commen);
    }

    @Override
    public void delete(Commen commen) {
        commentRepo.delete(commen);
    }

    @Override
    public void update(Commen commen) {
        commentRepo.update(commen);
    }
}
