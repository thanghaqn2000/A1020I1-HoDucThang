package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Role;
import vn.codegym.model.bean.User;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<Role,Integer> {
    List<Role> findByUsers(User user);
}
