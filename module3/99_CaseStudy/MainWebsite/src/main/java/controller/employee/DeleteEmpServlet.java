package controller.employee;

import model.service.employee.EmployeeService;
import model.service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmpServlet",urlPatterns = "/deleteEmp")
public class DeleteEmpServlet extends HttpServlet {
    EmployeeService employeeService=new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id= Integer.parseInt(request.getParameter("idEmp"));
            employeeService.deleteEmp(id);
        request.setAttribute("listEmployee",employeeService.selectAllEmp());
        request.getRequestDispatcher("jsp/employee/displayEmployee.jsp").forward(request,response);
    }
}
