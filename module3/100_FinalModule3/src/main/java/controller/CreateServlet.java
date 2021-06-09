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

@WebServlet(name = "CreateServlet",urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    GroundService groundService=new GroundServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addGround(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/mat_bang/create.jsp").forward(request,response);
    }
    private void addGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLoaiMatBang= Integer.parseInt(request.getParameter("idLoaiMatBang"));
        String trangThai=request.getParameter("trangThai");
        double dienTich= Double.parseDouble(request.getParameter("dienTich"));
        int tang= Integer.parseInt(request.getParameter("tang"));
        double giaTien= Double.parseDouble(request.getParameter("giaTien"));
        String ngayBatDau=request.getParameter("ngayBatDau");
        String ngayKetThuc=request.getParameter("ngayKetThuc");
        MatBang matBang=new MatBang(idLoaiMatBang,trangThai,dienTich,tang,giaTien,ngayBatDau,ngayKetThuc);
        groundService.insertGround(matBang);
        loadList(request,response);
    }
    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listGround",groundService.selectAllGround());
        request.getRequestDispatcher("jsp/mat_bang/display.jsp").forward(request,response);
    }
}
