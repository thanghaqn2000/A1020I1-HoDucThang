package model.service.employee.impl;

import model.bean.Employee;
import model.repository.employee.EmployeeRepo;
import model.repository.employee.impl.EmployeeRepoImpl;
import model.service.employee.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo=new EmployeeRepoImpl();
    @Override
    public List<Employee> selectAllEmp() {
        return employeeRepo.selectAllEmp();
    }

    @Override
    public boolean insertEmp(Employee employee) {
        return employeeRepo.insertEmp(employee);
    }

    @Override
    public boolean deleteEmp(int idEmp) {
        return employeeRepo.deleteEmp(idEmp);
    }

    @Override
    public boolean updateEmp(Employee employee) {
        return employeeRepo.updateEmp(employee);
    }

    @Override
    public List<Employee> findEmp(String nameEmp) {
        return employeeRepo.findEmp(nameEmp);
    }

    @Override
    public Employee selectEmp(int id) {
        return employeeRepo.selectEmp(id);
    }

    @Override
    public int getIdAuto() {
        return 0;
    }
}
