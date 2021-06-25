package com.example.controller;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.service.CustomerService;

@Controller
@RequestMapping(value = {"customer",""}, name = "studentController")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable("id") int studentId, ModelMap modelMap) {
        modelMap.addAttribute("student", customerService.findById(studentId));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("successMsg", "update customer: "
                + customer.getFirstName() + " success");
        return "redirect:/customer/list";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showStudentList() {
        return new ModelAndView("list", "customerList",
                customerService.findAll());
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id,RedirectAttributes redirectAttributes){
        Customer customer=customerService.findById(id);
        customerService.delete(customer);
        redirectAttributes.addFlashAttribute("successMsg", "delete customer: "
                + customer.getFirstName() + " success");
        return "redirect:/customer/list";
    }
    @GetMapping(value = "/create")
    public String showCreatePage(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping(value = "/create",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String createStudent(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("successMsg", "create student: "
                + customer.getFirstName() + " OK");
        System.out.println(customer);
        customerService.save(customer);
        return "redirect:/customer/list";
    }
}
