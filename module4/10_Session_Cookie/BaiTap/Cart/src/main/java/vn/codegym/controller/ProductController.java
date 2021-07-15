package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.bean.Cart;
import vn.codegym.bean.Product;
import vn.codegym.service.ProductService;

import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class ProductController {

        @ModelAttribute("carts")
    public HashMap<Integer, Cart> showInfo(){
            return new HashMap<>();
    }
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index", "products", productService.showAll());
    }

    @GetMapping("view/{id}")
    public ModelAndView view(@PathVariable int id,@SessionAttribute("carts") HashMap<Integer,Cart> cartMap) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("cartMap",cartMap);
        modelAndView.addObject("item", productService.findById(id));
        return modelAndView;
    }

}
