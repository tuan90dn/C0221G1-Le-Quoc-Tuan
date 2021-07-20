package controller;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;
import model.service.ContractDetailServicesImpl;
import model.service.ContractServicesImpl;
import model.service.IContractDetailServices;
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

@WebServlet(name = "ContractDetailServlet",value = "/contractdetails")
public class ContractDetailServlet extends HttpServlet {
    IContractDetailServices contractDetailServices;
    public void init(){
        contractDetailServices=new ContractDetailServicesImpl();
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
                case "using":
                    listContractDetailUsingService(request,response);
                    break;
//                case "search":
//                    showSearchForm(request, response);
//                    break;
                default:
                    listContractDetail(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList=contractDetailServices.selectAllContracts();
        List<AttachService> attachServiceList=contractDetailServices.selectAllAttachServices();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);

        request.getRequestDispatcher("/view/contract/create_contract_detail.jsp").forward(request,response);
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ContractDetail> contractDetails = contractDetailServices.selectAllContractDetails();
        request.setAttribute("contractDetails", contractDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract_detail.jsp");
        dispatcher.forward(request, response);
    }
    private void listContractDetailUsingService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ContractDetail> contractDetails = contractDetailServices.selectAllContractDetailsUsingService();
        request.setAttribute("contractDetails", contractDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract_using_service.jsp");
        dispatcher.forward(request, response);
    }


}
