package vn.codegym.service.customer;

import vn.codegym.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    List<Customer> findByName();
    Customer findById(String id);
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
}
