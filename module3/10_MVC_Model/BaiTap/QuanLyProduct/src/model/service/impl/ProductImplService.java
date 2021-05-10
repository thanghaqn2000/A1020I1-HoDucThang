package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductImplRepo;
import model.service.ProductService;

import java.util.List;

public class ProductImplService implements ProductService {
    private ProductRepository productRepository = new ProductImplRepo();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean save(Product product) {
        if(product.getProducer().equals("")||product.getName().equals("")||product.getDescribe().equals(""))
            return false;
        return productRepository.save(product);

    }

    @Override
    public boolean edit(int id, Product product) {
        return productRepository.edit(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
