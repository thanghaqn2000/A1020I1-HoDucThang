package model.service.employee;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectAllEmp();
    boolean insertEmp(Employee employee);
    boolean deleteEmp(int idEmp);
    boolean updateEmp(Employee employee);
    List<Employee> findEmp(String nameEmp);
    Employee selectEmp(int id);
    int getIdAuto();
}
