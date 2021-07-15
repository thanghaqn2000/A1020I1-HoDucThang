package ducthang.com.demo_springboot_gradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @GetMapping("/hello")
    public String HomePage(){
        return "index";
    }
}
