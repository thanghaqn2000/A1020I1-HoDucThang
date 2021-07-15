package vn.codegym.service.login;

import vn.codegym.model.bean.UserLogin;

public interface UserLoginService {
    boolean login(UserLogin userLogin);
}
