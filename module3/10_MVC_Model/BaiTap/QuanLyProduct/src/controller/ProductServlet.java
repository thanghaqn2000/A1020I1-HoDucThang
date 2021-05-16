package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductImplService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductImplService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionProduct");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
            case "search":
                searchProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionProduct");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
                showEditForm(request, response);
            case "search":
                showSearchForm(request, response);
                break;
        }
        loadList(request, response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        String describer = request.getParameter("describer");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name, price, describer, producer);
        if (productService.save(product)) {
            loadList(request, response);
        } else {
            request.setAttribute("msg", "Invalid data");
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("error 404.jsp");
        } else {
            productService.delete(id);
            loadList(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("editName");
        String producer = request.getParameter("editProducer");
        String describer = request.getParameter("editDescriber");
        double price = Double.parseDouble(request.getParameter("editPrice"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setName(name);
            product.setDescribe(describer);
            product.setPrice(price);
            product.setProducer(producer);
            productService.edit(id, product);
            loadList(request, response);
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("nameSearch");
        List<Product> product = productService.findByName(name);
        if (product.isEmpty()) {
            request.setAttribute("msgErr", "Can't find this product");
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } else {
            request.setAttribute("productSearch", product);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
