package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void remove( Customer customer);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
