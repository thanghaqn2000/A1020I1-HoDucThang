package vn.codegym.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Role;
import vn.codegym.repository.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;
    @Override
    public Role findById(int id) {
        return roleRepo.findById(id).orElse(null);
    }
}
