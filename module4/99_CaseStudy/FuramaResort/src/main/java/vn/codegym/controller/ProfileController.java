package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.*;
import vn.codegym.repository.employee.DivisionRepo;
import vn.codegym.repository.employee.EducationDegreeRepo;
import vn.codegym.repository.employee.PositionRepo;
import vn.codegym.service.common.BCryptPassword;
import vn.codegym.service.employee.EmployeeService;
import vn.codegym.service.role.RoleService;
import vn.codegym.service.user.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ProfileController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionRepo divisionRepo;
    @Autowired
    PositionRepo positionRepo;
    @Autowired
    EducationDegreeRepo educationDegreeRepo;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPassword bCryptPassword;

    @ModelAttribute("listPosition")
    public List<Position> getPositions() {
        return positionRepo.findAll();
    }

    @ModelAttribute("listDivision")
    public List<Division> getDivisions() {
        return divisionRepo.findAll();
    }

    @ModelAttribute("listDegree")
    public List<EducationDegree> geEducationDegrees() {
        return educationDegreeRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public ModelAndView profile(@PathVariable int id, Principal principal) {
        User user = userService.findByName(principal.getName());

        ModelAndView modelAndView = new ModelAndView("/employee/user");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/user/update")
    public String update(@Valid @ModelAttribute Employee employee,
                         BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/user";
        }
        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionId() == 6 || employee.getPosition().getPositionId() == 5)
            roles.add(roleService.findById(1));
        else
            roles.add(roleService.findById(2));
        employee.getUser().setRoles(roles);
        attributes.addFlashAttribute("msg", "Update profile: "
                + employee.getEmployeeName() + " successful!");
        employeeService.update(employee);
        return "redirect:/admin";
    }

    @GetMapping("/userAccount")
    public ModelAndView account(Principal principal) {
        User user = userService.findByName(principal.getName());
        ModelAndView modelAndView = new ModelAndView("/employee/changePass");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("user/changePass")
    public String changePass(@ModelAttribute User user, @RequestParam String newPass, RedirectAttributes attributes) {
        Set<Role> roles = new HashSet<>();
        if (user.getEmployee().getPosition().getPositionId() == 6 || user.getEmployee().getPosition().getPositionId() == 5)
            roles.add(roleService.findById(1));
        else
            roles.add(roleService.findById(2));
        user.setRoles(roles);
        user.setPassword(bCryptPassword.encodePassword(newPass));
        userService.update(user);
        attributes.addFlashAttribute("msg", "Change pass success");
        return "redirect:/admin";
    }

}
