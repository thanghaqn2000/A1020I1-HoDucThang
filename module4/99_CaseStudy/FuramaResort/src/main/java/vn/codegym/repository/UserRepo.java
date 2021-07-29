package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
