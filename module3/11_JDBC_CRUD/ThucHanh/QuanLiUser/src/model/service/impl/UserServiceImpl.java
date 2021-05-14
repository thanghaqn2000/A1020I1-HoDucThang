package model.service.impl;

import model.bean.User;
import model.repository.UserRepo;
import model.repository.impl.UserRepoImpl;
import model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepo userRepo=new UserRepoImpl();
    @Override
    public boolean insertUser(User user) throws SQLException {
            return userRepo.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepo.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
