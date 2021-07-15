package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.bean.Cart;
import vn.codegym.bean.Product;
import vn.codegym.service.ProductService;

import java.util.HashMap;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("showCart")
    public ModelAndView show(@SessionAttribute("carts") HashMap<Integer, Cart> cartMap) {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("carts", cartMap);
        modelAndView.addObject("cartSize", cartMap.size());
        return modelAndView;
    }

    @GetMapping("addCart/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("carts") HashMap<Integer, Cart> cartMap, Model model) {
        if (cartMap == null) {
            cartMap = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product != null) {
            if (cartMap.containsKey(id)) {
                Cart item = cartMap.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartMap.put(id, item);
            } else {
                Cart cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                cartMap.put(id, cart);
            }
        }
        model.addAttribute("carts", cartMap);
        model.addAttribute("cartSize", cartMap.size());
        return "redirect:/showCart";
    }
}
