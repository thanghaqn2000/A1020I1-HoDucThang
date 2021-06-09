package controller;

import model.bean.MatBang;
import model.service.GroundService;
import model.service.impl.GroundServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    GroundService groundService=new GroundServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<MatBang> listGround = search == "" ? groundService.selectAllGround() :
                groundService.findGround(search);
        request.setAttribute("listGround",listGround);
        request.getRequestDispatcher("jsp/mat_bang/display.jsp").forward(request,response);
    }
}
