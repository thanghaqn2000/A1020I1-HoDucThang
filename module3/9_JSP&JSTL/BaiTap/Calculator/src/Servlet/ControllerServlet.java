package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", urlPatterns = "/calculate")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num_one"));
        int num2 = Integer.parseInt(request.getParameter("num_second"));
        int sum = 0;
        String err = "";
        try {
            String ope = request.getParameter("operator");
            switch (ope) {
                case "+":
                    sum = num1 + num2;
                    break;
                case "-":
                    sum = num1 - num2;
                    break;
                case "*":
                    sum = num1 * num2;
                    break;
                case "/":
                    sum = num1 / num2;
                    break;
                default:
                    err = "Phép tính không phù hợp";
                    break;
            }
        } catch (Exception e) {
            err = e.getMessage();
        }
        request.setAttribute("err", err);
        request.setAttribute("tong", sum);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
