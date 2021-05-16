package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {
        List<Product> findAll();
        boolean save(Product product);
        boolean edit(int id,Product product);
        void delete(int id);
        Product findById(int id);
        List<Product> findByName(String name);

}
