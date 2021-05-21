package controller.customer;

import model.bean.Customer;
import model.service.user.CustomerService;
import model.service.user.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionCustomer");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionCustomer");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                loadList(request, response);
                break;
            case "create":
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer", customerService.selectAllCus());
        request.getRequestDispatcher("displayCustomer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (customerService.deleteCus(id)) {
            loadList(request, response);
        } else {
            System.out.println("Error");
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String dof = request.getParameter("dof");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(typeId, name, dof, idCard, phone, email, address);
        if (customerService.insertCus(customer)) {
            loadList(request, response);
        } else {
            System.out.println(customer.toString());
            request.setAttribute("msg", "Error");
            request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
        }
    }

}
