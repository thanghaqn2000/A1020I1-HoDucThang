package com.example.testfinal.controller;

import com.example.testfinal.model.Promotion;
import com.example.testfinal.repository.PromotionRepo;
import com.example.testfinal.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    PromotionService promotionService;
    @Autowired
    PromotionRepo promotionRepo;

    @RequestMapping("/list")
    public String index(Model model) {
        return viewPage(model, 1);
    }

    @GetMapping("/list/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
        int pageSize = 3;
        Page<Promotion> page = promotionService.findAll(pageNum, pageSize);

        List<Promotion> listPromotion = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listPromotion", listPromotion);

        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Promotion promotion, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (promotion.getEndDate().equals("")) {
            bindingResult.addError(new FieldError("promotion", "endDate", "End date must not empty"));
            return "/create";
        }
        if (promotion.getStartDate().equals("")) {
            bindingResult.addError(new FieldError("promotion", "startDate", "Start date must not empty"));
            return "/create";
        }
        LocalDate currentDate = java.time.LocalDate.now();
        LocalDate startDate = LocalDate.parse(promotion.getStartDate());
        LocalDate endDate = LocalDate.parse(promotion.getEndDate());
        if (ChronoUnit.DAYS.between(startDate, endDate) < 1) {
            bindingResult.addError(new FieldError("promotion", "endDate", "End date must be greater than start date"));
            return "/create";
        }
        if (ChronoUnit.DAYS.between(currentDate, startDate) < 1) {
            bindingResult.addError(new FieldError("promotion", "startDate", "Start date must be greater than current date"));
            return "/create";
        }
        if ((bindingResult.hasFieldErrors())) {
            return "/create";
        }

        promotionService.create(promotion);
        attributes.addFlashAttribute("msg", "Created promotion: " + promotion.getPromotionName() + " success!");
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("promotion", promotionService.findById(id));
        return "detail";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("promotion", promotionService.findById(id));
        return "view";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Promotion promotion, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (promotion.getEndDate().equals("")) {
            bindingResult.addError(new FieldError("promotion", "endDate", "End date must not empty"));
            return "/detail";
        }
        if (promotion.getStartDate().equals("")) {
            bindingResult.addError(new FieldError("promotion", "startDate", "Start date must not empty"));
            return "/detail";
        }
        LocalDate currentDate = java.time.LocalDate.now();
        LocalDate startDate = LocalDate.parse(promotion.getStartDate());
        LocalDate endDate = LocalDate.parse(promotion.getEndDate());

        if (ChronoUnit.DAYS.between(startDate, endDate) < 1) {
            bindingResult.addError(new FieldError("promotion", "endDate", "End date must be greater than start date"));
            return "/detail";
        }
        if (ChronoUnit.DAYS.between(currentDate, startDate) < 1) {
            bindingResult.addError(new FieldError("promotion", "startDate", "Start date must be greater than current date"));
            return "/detail";
        }
        if ((bindingResult.hasFieldErrors())) {
            return "/detail";
        }

        promotionService.update(promotion);
        attributes.addFlashAttribute("msg", "Updated promotion: " + promotion.getPromotionName() + " success!");
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes attributes) {
        String name = promotionService.findById(id).getPromotionName();
        promotionService.delete(id);
        attributes.addFlashAttribute("msg", "Deleted promotion: " +
                name + " success!");
        return "redirect:/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam String startDate, String endDate, Double money, Model model,
                         @PageableDefault(value = 3) Pageable pageable, RedirectAttributes attributes) {

        if (startDate.equals("") && endDate.equals("")) {
            model.addAttribute("listPromotion",
                    promotionRepo.findByMoneyPromotion(money, pageable));
            return "index";
        }
        if (startDate.equals("") && money == null) {
            model.addAttribute("listPromotion",
                    promotionRepo.findByEndDate(endDate, pageable));
            return "index";
        }
        if (endDate.equals("") && money == null) {
            model.addAttribute("listPromotion",
                    promotionRepo.findByStartDate(startDate, pageable));
            return "index";
        }
        model.addAttribute("listPromotion",
                promotionService.findPromotion(startDate, endDate, money, pageable));
        return "index";
    }

    @GetMapping("/searchGet")
    public String search(@RequestParam String name, Model model, @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("listPromotion", promotionService.findPromotionName(name, pageable));
        return "result";
    }

    @ExceptionHandler(NullPointerException.class)
    public String processNull() {
        return "error";
    }

    @RequestMapping(value = "/nullPointerException")// value chữ gì cũng được
    public String testNull() throws NullPointerException {
        throw new NullPointerException("this is null pointer exception");
    }
}
