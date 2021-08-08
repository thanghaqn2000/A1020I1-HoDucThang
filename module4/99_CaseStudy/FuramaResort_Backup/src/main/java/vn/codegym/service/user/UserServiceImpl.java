package vn.codegym.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public boolean checkAccount(String account) {
        return userRepo.existsByUserName(account);
    }
}
