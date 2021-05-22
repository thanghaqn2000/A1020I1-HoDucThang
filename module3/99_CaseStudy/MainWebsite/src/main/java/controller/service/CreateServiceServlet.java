package controller.service;

import model.bean.Service;
import model.service.serviceFurama.ServiceFu;
import model.service.serviceFurama.impl.ServiceFuImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServiceServlet", urlPatterns = "/createService")
public class CreateServiceServlet extends HttpServlet {
    ServiceFu serviceFu = new ServiceFuImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeServiceId = Integer.parseInt(request.getParameter("typeService"));
        int typeRentalId = Integer.parseInt(request.getParameter("typeRental"));
        double area = Double.parseDouble(request.getParameter("area"));
        double floor = Double.parseDouble(request.getParameter("floor"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max = Integer.parseInt(request.getParameter("max"));
        String nameService = request.getParameter("name");
        String status = request.getParameter("status");
        Service service=new Service(typeServiceId,typeRentalId,nameService,area,floor,max,cost,status);
        if( serviceFu.insertService(service)){
            request.setAttribute("listService",serviceFu.selectAllService());
            request.getRequestDispatcher("jsp/service/displayService.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("jsp/service/createService.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/service/createService.jsp").forward(request, response);
    }
}
