package controller;

import model.bean.employee_class.Employee;
import model.bean.service_class.Service;
import model.service.CustomerServicesImpl;
import model.service.ICustomerServices;
import model.service.IServiceServices;
import model.service.ServiceServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet",value = "/services")
public class ServiceServlet extends HttpServlet {
    IServiceServices serviceServices;
    public void init(){
        serviceServices=new ServiceServicesImpl();
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
                    showEditForm(request, response);
                    break;
                case "view":
//                    showInformationOfCustomer(request, response);
                    break;
                case "search":
//                    showSearchForm(request, response);
                    break;
                default:
                    listServicesOrderByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service existingUser = serviceServices.selectServiceByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/edit_service.jsp");
        request.setAttribute("service", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create_service.jsp");
        dispatcher.forward(request, response);
    }

    private void listServicesOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Service> listService = serviceServices.selectAllServices();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
        dispatcher.forward(request, response);
    }
}
