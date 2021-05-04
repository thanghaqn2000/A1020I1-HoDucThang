package Servlet;

import Bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet.ControllerServlet",urlPatterns = "/")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=new ArrayList<>();
        customerList.add(new Customer("Hồ Đức Thắng","2000-09-18","Hội An","https://st.depos" +
                "itphotos.com/1597387/1984/i/600/depositphotos_19841901-stock-photo-asian-young-business-man-close.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Nam Định","https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        customerList.add(new Customer("Nguyễn Thái Hòa","1983-08-17","Hà Tây","../img/anh3.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi","21983-08-19","Hà Nội","../img/anh4.jpg"));
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }
}
