package com.example.repository;

import com.example.model.Commen;
import org.hibernate.Session;

import java.util.List;

public class CommentRepoImpl implements CommentRepo {
    @Override
    public List<Commen> findAll() {
        Session session = null;
        List commentList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            commentList = session.createQuery("FROM Commen").getResultList();
        } finally {
            if (session != null)
                session.close();
        }
        return commentList;
    }

    @Override
    public void create(Commen commen) {

    }

    @Override
    public void delete(Commen commen) {

    }

    @Override
    public void update(Commen commen) {

    }
}
