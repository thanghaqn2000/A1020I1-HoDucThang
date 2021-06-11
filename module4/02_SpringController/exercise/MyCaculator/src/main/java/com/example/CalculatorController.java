package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public ModelAndView homePage(){
        return new ModelAndView("index");
    }
    @GetMapping("/calculator")
    public ModelAndView plus(@RequestParam Integer number1,@RequestParam Integer number2,@RequestParam String operator){
        ModelAndView modelAndView=new ModelAndView("index");
        int result=0;
        String msg=null;
        switch (operator){
            case "+":
                result=number1+number2;
                break;
            case "-":
                result=number1-number2;
                break;
            case "*":
                result=number1*number2;
                break;
            case "/":
                if(number2!=0)
                    result=number1/number2;
                else
                    msg="Can't division zero";
                break;
        }
        if(number1==null)
            msg="You need to type number in input";
        //msg=number1==null || number2==null? "You need to type number in input":null;
        modelAndView.addObject("msg",msg);
        modelAndView.addObject("kq",result);
        return modelAndView;
    }
}
