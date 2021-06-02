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

@WebServlet(name = "DetailEmpServlet",urlPatterns = "/detailEmp")
public class DetailEmpServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmp(id);
        if(employee==null){
            request.getRequestDispatcher("jsp/employee/displayEmployee.jsp").forward(request, response);

        }else{
            request.setAttribute("Employee", employee);
            request.getRequestDispatcher("jsp/employee/detailEmployee.jsp").forward(request, response);
        }
    }
}
