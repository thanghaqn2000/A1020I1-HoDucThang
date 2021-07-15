package vn.codegym.repository.login;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.NhanVien;

public interface UserLoginRepo extends JpaRepository<NhanVien,Integer> {
}
