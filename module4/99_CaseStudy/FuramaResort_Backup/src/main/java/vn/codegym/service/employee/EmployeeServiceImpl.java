package vn.codegym.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Employee;
import vn.codegym.repository.employee.EmployeeRepo;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<Employee> findByName(String name,Pageable pageable) {
        return employeeRepo.searchName(name,pageable);
    }

    @Override
    public Set<String> selectName(String name) {
        return employeeRepo.selectName(name);
    }

    @Override
    public boolean existById(int id) {
        return employeeRepo.existsByEmployeeId(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void create(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public boolean checkId(String id) {
        return false;
    }
}
