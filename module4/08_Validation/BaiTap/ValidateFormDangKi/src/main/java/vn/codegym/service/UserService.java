package vn.codegym.service;

import vn.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
