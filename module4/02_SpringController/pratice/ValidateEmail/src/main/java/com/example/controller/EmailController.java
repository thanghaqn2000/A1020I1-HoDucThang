package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @PostMapping("/validate")
    public ModelAndView validateEmail(@RequestParam String email){
        ModelAndView modelAndView =new ModelAndView("index");
        String result="";
        if(email.matches(EMAIL_REGEX))
            result="Email hợp lệ";
        else
            result="Email không hợp lệ , hãy nhập lại";
        return modelAndView.addObject("result",result);
    }
}
