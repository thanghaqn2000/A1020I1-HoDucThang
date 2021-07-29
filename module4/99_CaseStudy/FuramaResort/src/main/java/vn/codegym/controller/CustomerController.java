package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.bean.Customer;
import vn.codegym.model.bean.CustomerType;
import vn.codegym.repository.customer.CustomerTypeRepo;
import vn.codegym.service.customer.CustomerService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeRepo customerTypeRepo;

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("/customer/list", "listCustomer", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("listType", customerTypeRepo.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listType", customerTypeRepo.findAll());
            return "customer/create";
        }
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/customer/detail");
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("listType", customerTypeRepo.findAll());
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/customer/view");
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("listType", customerTypeRepo.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listType", customerTypeRepo.findAll());
            return "/customer/detail";
        }
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
