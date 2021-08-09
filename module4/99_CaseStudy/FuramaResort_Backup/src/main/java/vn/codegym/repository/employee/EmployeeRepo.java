package vn.codegym.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.codegym.model.bean.Employee;

import java.util.Set;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT employee_name FROM employee " +
            " where employee_name like %:name% ", nativeQuery = true)
    Set<String> selectName(@Param("name") String nameEmp);

    @Query(value = "SELECT * FROM employee " +
            " where employee_name like %:nameEmp% ", nativeQuery = true)
    Page<Employee> searchName(@Param("nameEmp") String nameEmp, Pageable pageble);

    Boolean existsByEmployeeId(int id);
}
