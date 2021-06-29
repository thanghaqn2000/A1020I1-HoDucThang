package vn.codegym.blog.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.bean.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
