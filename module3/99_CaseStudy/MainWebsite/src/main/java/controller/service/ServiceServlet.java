package controller.service;

import model.service.serviceFurama.ServiceFu;
import model.service.serviceFurama.impl.ServiceFuImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceFu serviceFu=new ServiceFuImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listService",serviceFu.selectAllService());
        request.getRequestDispatcher("jsp/service/displayService.jsp").forward(request,response);
    }
}
