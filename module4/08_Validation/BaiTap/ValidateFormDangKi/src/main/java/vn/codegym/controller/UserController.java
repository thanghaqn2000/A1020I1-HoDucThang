package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;
import vn.codegym.service.UserService;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView("index", "listUser", userService.findAll());
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        //new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        userService.save(user);
        return "redirect:/";
    }
}
