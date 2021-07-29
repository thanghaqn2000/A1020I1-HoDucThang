package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.TuyenBay;
import vn.codegym.service.tuyenBay.TuyenBayService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"tuyenbay", ""})
public class TuyenBayController {
    @Autowired
    TuyenBayService tuyenBayService;

    @GetMapping("/list")
    public ModelAndView modelAndView(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("tuyenbay/list");
        modelAndView.addObject("sanBayQuocTe",tuyenBayService.quocTe());
        modelAndView.addObject("sanBayTrongNuoc",tuyenBayService.trongNuoc());
        modelAndView.addObject("listTB", tuyenBayService.findAllPage(pageable));
        return modelAndView;
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("tuyenbay/create");
        modelAndView.addObject("tuyenBay", new TuyenBay());
        modelAndView.addObject("listSB", tuyenBayService.listSanBay());
        modelAndView.addObject("listNB", tuyenBayService.listNoiBay());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute TuyenBay tuyenBay, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listSB", tuyenBayService.listSanBay());
            model.addAttribute("listNB", tuyenBayService.listNoiBay());
            return "tuyenbay/create";
        }
        tuyenBayService.save(tuyenBay);
        redirectAttributes.addFlashAttribute("msg",
                "Add flight route " + tuyenBay.getTenTuyenBay() + " successfully!");
        return "redirect:/tuyenbay/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTuyenBay(@PathVariable int id, RedirectAttributes redirectAttributes) {
        tuyenBayService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/tuyenbay/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("tuyenbay/detail");
        modelAndView.addObject("tuyenBay", tuyenBayService.findById(id));
        modelAndView.addObject("listSB", tuyenBayService.listSanBay());
        modelAndView.addObject("listNB", tuyenBayService.listNoiBay());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute TuyenBay tuyenBay, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model, @RequestParam int id) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tuyenBay", tuyenBayService.findById(id));
            model.addAttribute("listSB", tuyenBayService.listSanBay());
            model.addAttribute("listNB", tuyenBayService.listNoiBay());
            return "tuyenbay/detail";
        }
        tuyenBayService.update(tuyenBay);
        redirectAttributes.addFlashAttribute("msg",
                "Updated flight route " + tuyenBay.getTenTuyenBay() + " successfully!");
        return "redirect:/tuyenbay/list";
    }

    @GetMapping("/filter")
    public ModelAndView filter(@PageableDefault(value = 3) Pageable pageable,
                               @RequestParam String loaiTuyenBay,
                               @RequestParam String sanBayDi, @RequestParam String sanBayDen) {
        ModelAndView modelAndView = new ModelAndView("tuyenbay/list");
        modelAndView.addObject("sanBayQuocTe",tuyenBayService.quocTe());
        modelAndView.addObject("sanBayTrongNuoc",tuyenBayService.trongNuoc());
        if (sanBayDi.equals("rong") || sanBayDen.equals("rong")) {
            modelAndView.addObject("listTB", tuyenBayService.filterTuyenBay(pageable, loaiTuyenBay));
            return modelAndView;
        }
        modelAndView.addObject("listTB", tuyenBayService.filter(pageable, loaiTuyenBay, sanBayDi, sanBayDen));
        return modelAndView;
    }
}
