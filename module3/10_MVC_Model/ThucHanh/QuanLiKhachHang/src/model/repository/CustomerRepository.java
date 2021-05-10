package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    boolean save(Customer customer);
    Customer findById(int idCustomer);
    boolean edit(int idCustomer,Customer customer);
    void delete(int idCustomer);
}
