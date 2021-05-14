package controller;

import model.bean.User;
import model.service.UserService;
import model.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"", "/user"})
public class Servlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                try {
                    createUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                System.out.println("create");
                break;
//            case "view":
//                viewProduct(request, response);
//                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
//                break;
//            case "edit":
//                showEditForm(request, response);
//            case "search":
//                showSearchForm(request, response);
//                break;
        }
        loadList(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException,
            IOException, SQLException {
        int id= Integer.parseInt(request.getParameter("id"));
        if(userService.deleteUser(id)){
            loadList(request,response);
        }else{
            request.setAttribute("msg","Xoa ko thanh cong");
            loadList(request,response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.insertUser(user);
        loadList(request,response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", userService.selectAllUsers());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
