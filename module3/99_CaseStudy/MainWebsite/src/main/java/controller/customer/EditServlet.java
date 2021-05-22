package controller.customer;

import common.Validate;
import model.bean.Customer;
import model.service.customer.CustomerService;
import model.service.customer.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = "/editCustomer")
public class EditServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeId = Integer.parseInt(request.getParameter("type"));
        int id = Integer.parseInt(request.getParameter("id"));
        String typeCustomer=request.getParameter("typeCustomer");
        String name = request.getParameter("name").trim();
        String dof = request.getParameter("dof").trim();
        String idCard = request.getParameter("idCard").trim();
        String phone = request.getParameter("phoneNumber").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        Customer customerTemp = new Customer(id,typeId, name, dof, idCard, phone, email, address);
        customerTemp.setType_Customer(typeCustomer);
        Customer customer = new Customer();
        Validate validate=new Validate();
        boolean check = true;
        if(name.equals("")){
            request.setAttribute("msgName","Enter incorrect name format");
            check=false;
        }
        if (!validate.checkIdCard(idCard)) {
            request.setAttribute("msgIdCard", "Enter incorrect Id Card format");
            check = false;
        } else {
            customer.setCustomer_Id_Card(idCard);
        }
        if (!validate.checkEmail(email)) {
            request.setAttribute("msgEmail", "Enter incorrect email format");
            check = false;
        } else {
            customer.setCustomer_Email(email);
        }
        if (!validate.checkPhone(phone)) {
            request.setAttribute("msgPhone", "Enter incorrect phone format");
            check = false;
        } else {
            customer.setCustomer_Phone(phone);
        }
        customer.setCustomer_Id(id);
        customer.setType_Customer_Id(typeId);
        customer.setCustomer_Name(name);
        customer.setCustomer_Birthday(dof);
        customer.setCustomer_Address(address);
        if (!check) {
            request.setAttribute("customer",customerTemp);
            request.getRequestDispatcher("jsp/user/editCustomer.jsp").forward(request, response);
        } else {
            if (customerService.updateCus(customer)) {
                request.setAttribute("listCustomer", customerService.selectAllCus());
                request.getRequestDispatcher("jsp/user/displayCustomer.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showEditForm(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Customer customer = customerService.selectCus(id);
        if (customer == null) {
            request.setAttribute("msg", "Can't find this user");
            request.getRequestDispatcher("jsp/user/editCustomer.jsp").forward(request, response);
        } else {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("jsp/user/editCustomer.jsp").forward(request, response);
        }
    }
}
