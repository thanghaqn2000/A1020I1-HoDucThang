package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.service.BookService;
import vn.codegym.validation.AmountLessThanZero;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/")
    public ModelAndView homePage(){
        return new ModelAndView("index","listBook",bookService.showAll());
    }

    @GetMapping("detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("detail");
        modelAndView.addObject("book",bookService.detail(id));
        return modelAndView;
    }
    @GetMapping("pay/{id}")
    public String payBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws AmountLessThanZero {
        int amount=bookService.detail(id).getAmount();
        if(amount<=0){
            throw new AmountLessThanZero();
        }
        bookService.pay(id);
        redirectAttributes.addFlashAttribute("msg","Pay book success!");
        return "redirect:/";
    }
    @GetMapping("borrow/{id}")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes){
        bookService.borrow(id);
        redirectAttributes.addFlashAttribute("msg","Borrow book success!");
        return "redirect:/";
    }
}
