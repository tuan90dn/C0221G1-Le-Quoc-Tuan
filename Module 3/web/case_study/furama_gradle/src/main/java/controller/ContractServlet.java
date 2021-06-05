package controller;

import model.bean.contract.Contract;
import model.bean.employee_class.Employee;
import model.service.ContractServicesImpl;
import model.service.EmployeeServicesImpl;
import model.service.IContractServices;
import model.service.IEmployeeServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet",value = "/contracts")
public class ContractServlet extends HttpServlet {
    IContractServices contractServices;
    public void init(){
        contractServices=new ContractServicesImpl();
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
//                    showNewForm(request, response);
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
                    listEmployeeOrderByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployeeOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Contract> listContract = contractServices.selectAllContracts();
        request.setAttribute("listContract", listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract.jsp");
        dispatcher.forward(request, response);
    }
}
