package controller.employee;

import model.bean.Employee;
import model.service.employee.EmployeeService;
import model.service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchEmpServlet", urlPatterns = "/searchEmp")
public class SearchEmpServlet extends HttpServlet {
    EmployeeService employeeService=new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch").trim();
        List<Employee> employeeList=name==""?employeeService.selectAllEmp():employeeService.findEmp(name);
        request.setAttribute("listEmployee",employeeList);
        request.getRequestDispatcher("jsp/employee/displayEmployee.jsp").forward(request,response);
    }
}
