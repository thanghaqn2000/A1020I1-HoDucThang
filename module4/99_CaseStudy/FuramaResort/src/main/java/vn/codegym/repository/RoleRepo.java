package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
