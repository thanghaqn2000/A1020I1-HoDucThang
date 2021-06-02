package controller.employee;

import common.Validate;
import model.bean.Employee;
import model.service.employee.EmployeeService;
import model.service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditEmpServlet", urlPatterns = "/editEmp")
public class EditEmpServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Validate validate=new Validate();
        int idPosition = Integer.parseInt(request.getParameter("position").trim());
        int idLevel = Integer.parseInt(request.getParameter("level").trim());
        int idDepartment = Integer.parseInt(request.getParameter("department").trim());
        double salary=Double.parseDouble(request.getParameter("salary"));
        String name = request.getParameter("name").trim();
        String dof = request.getParameter("dof").trim();
        String idCard = request.getParameter("idCard").trim();
        String phone = request.getParameter("phoneNumber").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        Employee employee = new Employee();
        boolean check = true;
        if (name.equals("")) {
            request.setAttribute("msgName", "Enter incorrect name format");
            check = false;
        }
        if (!validate.checkIdCard(idCard)) {
            request.setAttribute("msgIdCard", "Enter incorrect Id Card format");
            check = false;
        } else {
            employee.setId_Card(idCard);
        }
        if (!validate.checkEmail(email)) {
            request.setAttribute("msgEmail", "Enter incorrect email format");
            check = false;
        } else {
            employee.setEmail(email);
        }
        if (!validate.checkPhone(phone)) {
            request.setAttribute("msgPhone", "Enter incorrect phone format");
            check = false;
        } else {
            employee.setPhoneNumber(phone);
        }
        if(salary < 0){
            request.setAttribute("msgSalary", "Salary must be greater than zero");
            check=false;
        }else{
            employee.setSalary(salary);
        }
        if (!check) {
            Employee employeeTemp = employeeService.selectEmp(id);
            request.setAttribute("Employee", employeeTemp);
            request.getRequestDispatcher("jsp/employee/editEmployee.jsp").forward(request, response);
        } else {
            employee.setId_Employee(id);
            employee.setId_Position(idPosition);
            employee.setId_Level(idLevel);
            employee.setId_Department(idDepartment);
            employee.setName(name);
            employee.setDof(dof);
            employee.setAddress(address);
            if (employeeService.updateEmp(employee)) {
                request.setAttribute("listEmployee",employeeService.selectAllEmp());
                request.getRequestDispatcher("jsp/employee/displayEmployee.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmp(id);
        if(employee==null){
            request.getRequestDispatcher("jsp/employee/displayEmployee.jsp").forward(request, response);

        }else{
            request.setAttribute("Employee", employee);
            request.getRequestDispatcher("jsp/employee/editEmployee.jsp").forward(request, response);
        }
    }
}
