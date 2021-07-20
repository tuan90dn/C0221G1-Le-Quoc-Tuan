package controller;

import model.bean.contract.Contract;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;
import model.service.ContractServicesImpl;
import model.service.IContractServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contracts")
public class ContractServlet extends HttpServlet {
    IContractServices contractServices;

    public void init() {
        contractServices = new ContractServicesImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "view":
//                    showInformationOfEmployee(request, response);
                    break;
//                case "search":
//                    showSearchForm(request, response);
//                    break;
                default:
                    listContract(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = contractServices.selectAllCustomers();
        List<Employee> employeeList = contractServices.selectAllEmployees();
        List<Service> serviceList = contractServices.selectAllServices();
        request.setAttribute("customerList", customerList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("/view/contract/create_contract.jsp").forward(request, response);

    }

    //    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
//        List<Contract> listContract = contractServices.selectAllContracts();
//        request.setAttribute("listContract", listContract);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract_using_service.jsp");
//        dispatcher.forward(request, response);
//    }
    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Contract> listContract = contractServices.selectAllContracts();
        request.setAttribute("listContract", listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract.jsp");
        dispatcher.forward(request, response);
    }
}
