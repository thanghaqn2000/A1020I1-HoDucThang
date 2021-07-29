package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.model.bean.TuyenBay;
import vn.codegym.repository.chuyenBay.ChuyenBayRepo;
import vn.codegym.repository.tuyenBay.TuyenBayRepo;
import vn.codegym.service.chuyenBay.ChuyenBayService;
import vn.codegym.service.tuyenBay.TuyenBayService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static vn.codegym.common.Input_Output.writeFileCB;

@Controller
@RequestMapping(value = {"chuyenbay", ""})
public class ChuyenBayController {
    @Autowired
    ChuyenBayService chuyenBayService;
    @Autowired
    TuyenBayService tuyenBayService;
    @Autowired
    ChuyenBayRepo chuyenBayRepo;
    @Autowired
    TuyenBayRepo tuyenBayRepo;

    @GetMapping("/list")
    public ModelAndView home(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/list");
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        modelAndView.addObject("listCB", chuyenBayService.findAllPage(pageable));
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/detail");
        modelAndView.addObject("chuyenBay", chuyenBayService.findById(id));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ChuyenBay chuyenBay, RedirectAttributes redirectAttributes) {
        chuyenBayService.update(chuyenBay);
        redirectAttributes.addFlashAttribute("msg", "Update successful!");
        return "redirect:/chuyenbay/list";
    }

    @GetMapping("/search")
    public ModelAndView searchSohieu(@PageableDefault(value = 3) Pageable pageable, @RequestParam String soHieu) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/list");
        modelAndView.addObject("listCB", chuyenBayService.findSoHieu(pageable, soHieu));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/filter")
    public ModelAndView filter(@PageableDefault(value = 3) Pageable pageable,
                               @RequestParam String tenTuyenBay, @RequestParam String loaiTuyenBay,
                               @RequestParam String tinhTrang, @RequestParam String ngayDi, @RequestParam String ngay_Den) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/list");
        if (ngay_Den.equals("") && ngayDi.equals("")) {
            if (tenTuyenBay.equals("rong")) {
                modelAndView.addObject("listCB", chuyenBayService.filterTinhTrang(tinhTrang, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            } else if (tinhTrang.equals("rong")) {
                modelAndView.addObject("listCB", chuyenBayService.filterTenTB(tenTuyenBay, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            } else {
                modelAndView.addObject("listCB", chuyenBayService.filterTenTB_TinhTrang(tenTuyenBay, tinhTrang, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            }
        }
        if (tenTuyenBay.equals("rong") && tinhTrang.equals("rong")) {
            modelAndView.addObject("listCB", chuyenBayService.filterNgayDi_NgayDen(ngayDi, ngay_Den, loaiTuyenBay, pageable));
            modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
            return modelAndView;
        }
        if (!tenTuyenBay.equals("rong") && !tinhTrang.equals("rong") && !ngayDi.equals("") && !ngay_Den.equals("")) {
            modelAndView.addObject("listCB", chuyenBayService.filterAll(pageable, tenTuyenBay, loaiTuyenBay, tinhTrang, ngayDi, ngay_Den));
            modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
            return modelAndView;
        }
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, loaiTuyenBay));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/quocTe")
    public ModelAndView quocTe(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/list");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Quốc tế"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/trongNuoc")
    public ModelAndView trongNuoc(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/list");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Trong nước"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/thong_ke")
    public ModelAndView thongKeDieuKien(@PageableDefault(value = 20) Pageable pageable,
                                        @RequestParam String tenTuyenBay, @RequestParam String loaiTuyenBay,
                                        @RequestParam String tinhTrang, @RequestParam String ngayDi, @RequestParam String ngay_Den) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/thong_ke");
        if (ngay_Den.equals("") && ngayDi.equals("")) {
            if (tenTuyenBay.equals("rong")) {
                modelAndView.addObject("listCB", chuyenBayService.filterTinhTrang(tinhTrang, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            } else if (tinhTrang.equals("rong")) {
                modelAndView.addObject("listCB", chuyenBayService.filterTenTB(tenTuyenBay, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            } else {
                modelAndView.addObject("listCB", chuyenBayService.filterTenTB_TinhTrang(tenTuyenBay, tinhTrang, loaiTuyenBay, pageable));
                modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
                return modelAndView;
            }
        }
        if (tenTuyenBay.equals("rong") && tinhTrang.equals("rong")) {
            modelAndView.addObject("listCB", chuyenBayService.filterNgayDi_NgayDen(ngayDi, ngay_Den, loaiTuyenBay, pageable));
            modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
            return modelAndView;
        }
        if (!tenTuyenBay.equals("rong") && !tinhTrang.equals("rong") && !ngayDi.equals("") && !ngay_Den.equals("")) {
            modelAndView.addObject("listCB", chuyenBayService.filterAll(pageable, tenTuyenBay, loaiTuyenBay, tinhTrang, ngayDi, ngay_Den));
            modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
            return modelAndView;
        }
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, loaiTuyenBay));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/thongke/quocTe")
    public ModelAndView thongKe_quocTe(@PageableDefault(value = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/thong_ke");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Quốc tế"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("thongke/trongNuoc")
    public ModelAndView thongke_trongNuoc(@PageableDefault(value = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/thong_ke");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Trong nước"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/thongke/all")
    public ModelAndView thongKeAll(@PageableDefault(value = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/thong_ke");
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        modelAndView.addObject("listCB", chuyenBayService.findAllPage(pageable));
        return modelAndView;
    }

    @GetMapping("thongke/search")
    public ModelAndView thongkeSearch(@PageableDefault(value = 20) Pageable pageable, @RequestParam String soHieu) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/thong_ke");
        modelAndView.addObject("listCB", chuyenBayService.findSoHieu(pageable, soHieu));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }
}
