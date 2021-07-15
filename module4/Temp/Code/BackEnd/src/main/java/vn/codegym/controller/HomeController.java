package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.repository.home.SearchRepo;
import vn.codegym.service.tuyenBay.TuyenBayService;

@Controller
public class HomeController {
    @Autowired
    TuyenBayService tuyenBayService;
    @Autowired
    SearchRepo searchRepo;
    @RequestMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("listTB",tuyenBayService.findAll());
       return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView timKiem(@PageableDefault(value = 3) Pageable pageable,@RequestParam String NoiDen,
                                @RequestParam String NgayDi , @RequestParam String NgayDen,
                                @RequestParam String tenTuyenBay){
        if (NgayDen.equals("")||NgayDi.equals("")){
            NgayDen="2000/01/01";
            NgayDi="2000/01/01";
        }
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("listTB",tuyenBayService.findAll());
        modelAndView.addObject("listCB",searchRepo.timKiem(pageable, tenTuyenBay,NoiDen,NgayDi,NgayDen));
        return modelAndView;
    }

}
