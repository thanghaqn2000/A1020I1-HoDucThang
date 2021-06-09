package controller;

import model.service.GroundService;
import model.service.impl.GroundServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    GroundService groundService=new GroundServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id= Integer.parseInt(request.getParameter("id"));
            groundService.deleteGround(id);
            loadList(request,response);
    }
    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listGround",groundService.selectAllGround());
        request.getRequestDispatcher("jsp/mat_bang/display.jsp").forward(request,response);
    }
}
