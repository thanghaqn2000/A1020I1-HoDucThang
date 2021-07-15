package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.bean.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
