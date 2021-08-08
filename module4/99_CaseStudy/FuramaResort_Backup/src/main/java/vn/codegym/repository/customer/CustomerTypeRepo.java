package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.CustomerType;

public interface CustomerTypeRepo extends JpaRepository<CustomerType,Integer> {
}
