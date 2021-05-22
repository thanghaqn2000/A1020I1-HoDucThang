package controller.customer;

import model.service.customer.CustomerService;
import model.service.customer.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewServlet",urlPatterns = "/viewCustomer")
public class ViewServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer",customerService.selectAllCus());
        request.getRequestDispatcher("jsp/user/displayCustomer.jsp").forward(request,response);
    }
}
