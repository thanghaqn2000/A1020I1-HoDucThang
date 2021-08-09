package vn.codegym.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.bean.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT customer_name FROM customer " +
            " where customer_name like %:name% ", nativeQuery = true)
    Set<String> selectName(@Param("name") String nameCus);

    @Query(value = "SELECT * FROM customer " +
            " where customer_name like %:nameCus% ", nativeQuery = true)
    Page<Customer> searchName(@Param("nameCus") String nameCus,Pageable pageble);

}
