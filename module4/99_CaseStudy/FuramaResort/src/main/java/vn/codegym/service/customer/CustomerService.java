package vn.codegym.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    Page<Customer> findAllSort(int pageNum,int pageSize);
    Page<Customer> findByName(String name,Pageable pageable);
    Set<String> selectName(String name);
    Customer findById(String id);
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    boolean checkId(String id);
}
