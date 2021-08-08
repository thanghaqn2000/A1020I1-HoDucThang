package vn.codegym.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.User;
import vn.codegym.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public boolean checkAccount(String account) {
        return userRepo.existsByUserName(account);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByUserName(name);
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }
}
