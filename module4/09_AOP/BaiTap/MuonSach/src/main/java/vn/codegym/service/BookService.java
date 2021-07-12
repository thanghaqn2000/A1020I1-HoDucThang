package vn.codegym.service;

import vn.codegym.model.Book;

import java.util.List;

public interface BookService {
    List<Book> showAll();
    void save(Book book);
    void delete(int id);
    void borrow(int id);
    void pay(int id);
    Book detail(int id);
}
