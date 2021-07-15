package vn.codegym.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.NhanVien;
import vn.codegym.model.bean.UserLogin;
import vn.codegym.repository.login.UserLoginRepo;

import java.util.List;

@Service
public class UserLoginImpl implements UserLoginService{
    @Autowired
    UserLoginRepo userLoginRepo;

    @Override
    public boolean login(UserLogin userLogin) {
        List<NhanVien> listNV=userLoginRepo.findAll();
        for (NhanVien nv:listNV) {
            if(userLogin.getEmail().equals(nv.getEmail())&&userLogin.getPassword().equals(nv.getMatKhau()))
                return true;
        }
        return false;
    }
}
