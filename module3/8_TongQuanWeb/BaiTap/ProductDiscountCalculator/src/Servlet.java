import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/calculatorDiscount")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            double listPrice=Double.parseDouble(request.getParameter("listPrice"));
            double discountPercent=Double.parseDouble(request.getParameter("discountPercent"));
            double discountAmount=listPrice*discountPercent*0.01;
            request.setAttribute("discountAmount",discountAmount);
            request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
