package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.bean.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
