package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.config.MyConstants;
import vn.codegym.repository.UserRepo;
import vn.codegym.service.common.BCryptPassword;
import vn.codegym.service.user.UserService;
import vn.codegym.ultils.WebUtils;

import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPassword bCryptPassword;
    @Autowired
    public JavaMailSender emailSender;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        vn.codegym.model.bean.User user = userService.findByName(principal.getName());
        model.addAttribute("user", user);
        System.out.println(user.getEmployee().getEmployeeName());
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

    @RequestMapping(value = "/forgotPass", method = RequestMethod.GET)
    public String forgotPass(Model model) {

        return "forgotPassword";
    }

    @PostMapping("/sendMail")
    public String sendSimpleEmail(@RequestParam String email, Model model, RedirectAttributes attributes) {
        vn.codegym.model.bean.User user = userRepo.findByEmployee_EmployeeEmail(email);
        if (user == null) {
            attributes.addFlashAttribute("msg","Can't found your email , please remember it !");
            return "redirect:/forgotPass";
        }
        String newPass = "codegym";
        user.setPassword(bCryptPassword.encodePassword(newPass));
        userRepo.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thangit189@gmail.com");
        message.setTo(email);
        message.setSubject("CÓ CÁI MẬT KHẨU MÀ QUÊN HOÀI DZẬY BA!");
        message.setText("Mật khẩu mới là: "+newPass);
        this.emailSender.send(message);

        return "changePassSuccess";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);

        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//            String userInfo = WebUtils.toString(loginedUser);
//
//            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }

}
