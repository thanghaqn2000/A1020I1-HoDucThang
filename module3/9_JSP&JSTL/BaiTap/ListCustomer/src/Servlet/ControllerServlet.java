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

@WebServlet(name = "Servlet.ControllerServlet", urlPatterns = "/")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Hồ Đức Thắng", "2000-09-18", "Hội An", "Images/anh1.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Nam Định", "Images/anh4.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-17", "Hà Tây", "Images/anh3.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "Images/anh2.jpg"));
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("display.jsp").forward(request, response);

    }
}
