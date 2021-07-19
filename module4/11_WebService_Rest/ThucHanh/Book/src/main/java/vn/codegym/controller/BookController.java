package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import vn.codegym.bean.Book;
import vn.codegym.repository.BookRepo;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @RequestMapping("/getAll")
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @RequestMapping("/")
    public ModelAndView renderFooList() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("foos", bookRepo.findAll());
        return mav;
    }

    @PostMapping("/save")
    public Book create(@RequestBody Book book) {
        Book books = bookRepo.save(book);
        return books;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        bookRepo.findById(id)
                .orElseThrow(null);
        bookRepo.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id) {
        bookRepo.findById(id)
                .orElseThrow(null);
        return bookRepo.save(book);
    }

    @GetMapping("find/{id}")
    public Book find(@PathVariable int id) {
        return bookRepo.findById(id)
                .orElseThrow(null);
    }
}
