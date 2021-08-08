package vn.codegym.service.user;

import vn.codegym.model.bean.User;

public interface UserService {
    boolean checkAccount(String account);
    User findByName(String name);
    void update(User user);
}
