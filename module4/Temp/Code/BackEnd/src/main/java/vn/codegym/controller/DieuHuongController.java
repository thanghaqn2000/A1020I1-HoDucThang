package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.chuyenBay.ChuyenBayService;
import vn.codegym.service.tuyenBay.TuyenBayService;

@Controller
public class DieuHuongController {
    @Autowired
    ChuyenBayService chuyenBayService;
    @Autowired
    TuyenBayService tuyenBayService;

    @GetMapping("/dieuhuong/list")
    public ModelAndView home(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/dieu_huong");
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        modelAndView.addObject("listCB", chuyenBayService.findAllPage(pageable));
        return modelAndView;
    }

    @GetMapping("/dieuhuong/filter")
    public ModelAndView filter(@PageableDefault(value = 3) Pageable pageable,
                               @RequestParam String tenTuyenBay, @RequestParam String loaiTuyenBay,
                               @RequestParam String tinhTrang, @RequestParam String ngayDi, @RequestParam String ngay_Den) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/dieu_huong");
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

    @GetMapping("/dieuhuong/quocTe")
    public ModelAndView quocTe(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/dieu_huong");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Quốc tế"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }

    @GetMapping("/dieuhuong/trongNuoc")
    public ModelAndView trongNuoc(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("chuyenBay/dieu_huong");
        modelAndView.addObject("listCB", chuyenBayService.filter(pageable, "Trong nước"));
        modelAndView.addObject("tuyenBayList", tuyenBayService.findAll());
        return modelAndView;
    }
}
