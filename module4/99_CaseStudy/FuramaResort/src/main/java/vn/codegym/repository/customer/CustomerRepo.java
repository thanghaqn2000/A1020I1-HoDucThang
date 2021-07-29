package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
