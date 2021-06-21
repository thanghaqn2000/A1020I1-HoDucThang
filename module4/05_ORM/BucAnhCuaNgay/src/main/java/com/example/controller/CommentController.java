package com.example.controller;

import com.example.model.Commen;
import com.example.service.CommentService;
import com.example.service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {
    CommentService commentService=new CommentServiceImpl();
    @GetMapping("/home")
    public ModelAndView homePage(){
        ModelAndView modelAndView=new ModelAndView("index");
        List<Commen> a = new ArrayList<>();
//        a= commentService.findAll();
        modelAndView.addObject("listComment",commentService.findAll());
        return modelAndView;
    }
}
