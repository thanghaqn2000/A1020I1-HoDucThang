package controller.contract;

import model.bean.Contract;
import model.service.contract.ContractService;
import model.service.contract.impl.ContractServiceImpl;
import model.service.customer.CustomerService;
import model.service.customer.impl.CustomerServiceImpl;
import model.service.employee.EmployeeService;
import model.service.employee.impl.EmployeeServiceImpl;
import model.service.serviceFurama.ServiceFu;
import model.service.serviceFurama.impl.ServiceFuImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateContractServlet", urlPatterns = "/createContract")
public class CreateContractServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceFu serviceFu = new ServiceFuImpl();
    ContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEmp = Integer.parseInt(request.getParameter("idEmp"));
        int idCus = Integer.parseInt(request.getParameter("idCus"));
        int idSer = Integer.parseInt(request.getParameter("idSer"));
        String dateContract = request.getParameter("dateContract");
        String endDate = request.getParameter("endDate");
        double deposits = Double.parseDouble(request.getParameter("deposits"));
        double total = Double.parseDouble(request.getParameter("total"));
        Contract contract = new Contract(idEmp,idCus,idSer,dateContract,endDate,deposits,total);
        contractService.insert(contract);
        request.setAttribute("listContract",contractService.selectAll());
        request.getRequestDispatcher("jsp/contract/displayContract.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeService.selectAllEmp());
        request.setAttribute("listCustomer", customerService.selectAllCus());
        request.setAttribute("listService", serviceFu.selectAllService());
        request.getRequestDispatcher("jsp/contract/createContract.jsp").forward(request, response);
    }
}
