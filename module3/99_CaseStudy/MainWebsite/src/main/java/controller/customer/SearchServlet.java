package controller.customer;

import model.bean.Customer;
import model.service.customer.CustomerService;
import model.service.customer.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/searchCustomer")
public class SearchServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");
        List<Customer> listCustomer = name == "" ? customerService.selectAllCus() : customerService.findCus(name);
        request.setAttribute("listCustomer",listCustomer);
        request.getRequestDispatcher("jsp/user/displayCustomer.jsp").forward(request,response);
    }
}
