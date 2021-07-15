package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.NhanVien;
import vn.codegym.model.bean.UserLogin;
import vn.codegym.repository.login.UserLoginRepo;
import vn.codegym.service.login.UserLoginService;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    UserLoginRepo userLoginRepo;

    @GetMapping("/showLogin")
    public ModelAndView loginForm() {
        return new ModelAndView("login", "userLogin", new UserLogin());
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLogin userLogin, RedirectAttributes redirectAttributes, Model model) {
        boolean check = userLoginService.login(userLogin);
        List<NhanVien> listNV = userLoginRepo.findAll();
        for (NhanVien nv : listNV) {
            if (userLogin.getEmail().equals(nv.getEmail()) && userLogin.getPassword().equals(nv.getMatKhau())) {
                if (nv.getLoaiNhanVien().getId() == 1) {
                    return "redirect:/chuyenbay/list";
                } else {
                    return "redirect:/dieuhuong/list";
                }
            }
        }
        redirectAttributes.addFlashAttribute("msg", "Email or password incorrect!");
        return "redirect:/showLogin";
    }
}
