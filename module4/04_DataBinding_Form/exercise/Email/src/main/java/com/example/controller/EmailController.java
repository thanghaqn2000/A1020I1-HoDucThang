package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @GetMapping("")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("languages",emailService.listLanguage());
        modelAndView.addObject("pageList",emailService.listPage());
        modelAndView.addObject("email",new Email());
        return modelAndView;
    }

    @GetMapping("/showEmail")
    public ModelAndView showEmail(){
        ModelAndView modelAndView=new ModelAndView("reult");
        List<Email> emailList= emailService.showAll();
        modelAndView.addObject("listEmail",emailList);
        return modelAndView;
    }

    @PostMapping("/send")
    public String sendEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        if(email==null)
            redirectAttributes.addFlashAttribute("error","Có lỗi");
        else
            emailService.addEmail(email);
        return "redirect:/showEmail";
    }
}
