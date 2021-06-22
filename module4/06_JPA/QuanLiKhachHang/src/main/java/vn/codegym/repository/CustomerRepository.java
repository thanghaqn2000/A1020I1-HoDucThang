package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    List<Customer> findCustomer(String name);
    void save(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
}
