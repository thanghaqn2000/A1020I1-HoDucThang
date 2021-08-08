package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.*;
import vn.codegym.repository.RoleRepo;
import vn.codegym.repository.employee.DivisionRepo;
import vn.codegym.repository.employee.EducationDegreeRepo;
import vn.codegym.repository.employee.PositionRepo;
import vn.codegym.service.common.BCryptPassword;
import vn.codegym.service.employee.EmployeeService;
import vn.codegym.service.role.RoleService;
import vn.codegym.service.user.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
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

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("listEmp", employeeService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/createGet")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee, BindingResult bindingResult, Model model,
                         RedirectAttributes attributes) {
        if (userService.checkAccount(employee.getUser().getUserName())) {
            bindingResult.addError(new FieldError("employee", "user.userName", "Account name is already exist!"));
            return "/employee/create";
        }
        employee.getUser().setPassword(bCryptPassword.encodePassword(employee.getUser().getPassword()));
        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionId() == 6 || employee.getPosition().getPositionId() == 5)
            roles.add(roleService.findById(1));
        else
            roles.add(roleService.findById(2));
        employee.getUser().setRoles(roles);
        employeeService.create(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/employee/detail");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/employee/view");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/detail";
        }
        attributes.addFlashAttribute("msg", "Update employee: "
                + employee.getEmployeeName() + " successful!");
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg", "Delete customer: " +
                employeeService.findById(id).getEmployeeName() + " successful!");
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam String nameCus,Model model,@PageableDefault(value = 3) Pageable pageable) {
//        model.addAttribute("listCustomer",customerService.findByName(nameCus,pageable));
//        return "/customer/list";
//    }
//
//    @RequestMapping(value = "/autocomplete")
//    @ResponseBody
//    public Set<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
//        return customerService.selectName(term);
//    }

}
