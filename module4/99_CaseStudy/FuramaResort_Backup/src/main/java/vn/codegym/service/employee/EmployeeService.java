package vn.codegym.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.Customer;
import vn.codegym.model.bean.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();
    Page<Employee> findByName(String name,Pageable pageable);
    Set<String> selectName(String name);
    boolean existById(int id);
    Employee findById(int id);
    void create(Employee customer);
    void update(Employee customer);
    void delete(int id);
    boolean checkId(String id);
}
