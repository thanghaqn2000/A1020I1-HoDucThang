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
        return userRepo.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepo.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepo.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepo.updateUser(user);
    }

    @Override
    public List<User> findUser(String name) {
        return userRepo.findUser(name);
    }

    @Override
    public int getIdAuto() {
        return userRepo.getIdAuto();
    }

    @Override
    public boolean add_User_Transaction(User user) {
        return userRepo.add_User_Transaction(user);
    }
}
