package model.repository;

import model.bean.Product;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface ProductRepository {
        List<Product> findAll();
        boolean save(Product product);
        boolean edit(int id,Product product);
        void delete(int id);
        Product findById(int id);
        List<Product> findByName(String name);

}
