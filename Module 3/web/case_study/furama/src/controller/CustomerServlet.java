package controller;

import model.bean.Customer;
import model.service.CustomerServicesImpl;
import model.service.ICustomerServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerServices customerServices;
    public void init(){
        customerServices=new CustomerServicesImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
//                case "search":
//                    searchUserByCountry(request,response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
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

                default:
                    listCustomerOrderByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));
        customerServices.deleteUser(id);
        response.sendRedirect("/customers");

//        List<Customer> listUser = customerServices.selectAllCustomers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
//        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomerOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Customer> listCustomer = customerServices.selectAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
        dispatcher.forward(request, response);
    }
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        int id= Integer.parseInt(request.getParameter("idType"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("idGender"));
        String identity = request.getParameter("identity");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,name,birthday,gender,identity,phone, email, address);
        customerServices.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
        dispatcher.forward(request, response);
    }

//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
//        dispatcher.forward(request, response);
//    }

//    private void listCustomerOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> listCustomer = customerServices.selectAllUsers();
//        request.setAttribute("listCustomer", listCustomer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("../view/customer/list_customer.jsp");
//        dispatcher.forward(request, response);
//    }
}
