package vn.codegym.service;

import vn.codegym.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAll();
    Product findById(int id);
}
