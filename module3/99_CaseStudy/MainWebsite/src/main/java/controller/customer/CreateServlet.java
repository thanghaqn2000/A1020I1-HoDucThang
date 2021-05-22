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

@WebServlet(name = "CreateServlet",urlPatterns = "/createCustomer")
public class CreateServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            addCustomer(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/user/createCustomer.jsp").forward(request, response);
    }
    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validate emailValidate = new Validate("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Validate phoneValidate = new Validate("^09[0-1]\\d{7}$|^\\(84\\)\\+9[0-1]\\d{7}$");
        Validate idCardValidate = new Validate("^\\d{9}$|^\\d{12}$");
        int typeId = Integer.parseInt(request.getParameter("type").trim());
        String name = request.getParameter("name").trim();
        String dof = request.getParameter("dof").trim();
        String idCard = request.getParameter("idCard").trim();
        String phone = request.getParameter("phoneNumber").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        Customer customer=new Customer();
        boolean check=true;
        if(name.equals("")){
            request.setAttribute("msgName","Enter incorrect name format");
            check=false;
        }
        if(!idCardValidate.checkRegex(idCard)){
            request.setAttribute("msgIdCard","Enter incorrect Id Card format");
            check=false;
        }else{
            customer.setCustomer_Id_Card(idCard);
        }
        if(!emailValidate.checkRegex(email)){
            request.setAttribute("msgEmail","Enter incorrect email format");
            check=false;
        }else{
            customer.setCustomer_Email(email);
        }
        if(!phoneValidate.checkRegex(phone)){
            request.setAttribute("msgPhone","Enter incorrect phone format");
            check=false;
        }else{
            customer.setCustomer_Phone(phone);
        }
        if(!check){
            request.getRequestDispatcher("jsp/user/createCustomer.jsp").forward(request, response);
        }else{
        customer.setType_Customer_Id(typeId);
        customer.setCustomer_Name(name);
        customer.setCustomer_Birthday(dof);
        customer.setCustomer_Address(address);
        if (customerService.insertCus(customer)) {
            loadList(request, response);}
    }
    }
    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer", customerService.selectAllCus());
        request.getRequestDispatcher("jsp/user/displayCustomer.jsp").forward(request, response);
    }
}
