package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Book;
import vn.codegym.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void borrow(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null)
            book.borrowBook();
        bookRepository.save(book);
    }

    @Override
    public void pay(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null)
            book.payBook();
        bookRepository.save(book);
    }

    @Override
    public Book detail(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
