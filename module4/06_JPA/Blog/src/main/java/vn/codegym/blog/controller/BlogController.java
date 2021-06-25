package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.bean.Blog;
import vn.codegym.blog.model.service.BlogService;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("listBlog", blogService.showAll());
        return "index";
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String name){
        return new ModelAndView("index","listBlog",blogService.findBlog(name));
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Add success blog: " + blog.getTitle());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        return new ModelAndView("edit", "Blog", blogService.showDetail(id));
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        return new ModelAndView("detail", "Blog", blogService.showDetail(id));
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog Blog,RedirectAttributes redirectAttributes) {
        blogService.updateBlog(Blog);
        redirectAttributes.addFlashAttribute("msg","Update "+Blog.getTitle()+" success");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        Blog blog=blogService.showDetail(id);
        blogService.deleteBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Delete "+blog.getTitle()+" success");
        return "redirect:/";
    }
}
