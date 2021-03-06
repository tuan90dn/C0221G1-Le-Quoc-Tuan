package controller;

import model.bean.customer_class.Customer;
import model.bean.customer_class.CustomerType;
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
                    deleteCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "search":
                    searchCustomerByName(request,response);
                    break;
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
                case "edit":
                    showEditForm(request, response);
                    break;
                case "view":
                    showInformationOfCustomer(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "using":
                    listCustomerUsingService(request,response);
                    break;
                default:
                    listCustomerOrderByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/customer/search_customer.jsp").forward(request,response);
    }
    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        List<Customer> listCustomer=customerServices.selectCustomerByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/show_search_customer.jsp");
        request.setAttribute("listCustomer", listCustomer);
        dispatcher.forward(request, response);
    }

    private void showInformationOfCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=customerServices.selectCustomerByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/show_information.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingUser = customerServices.selectCustomerByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
        request.setAttribute("customer", existingUser);
        dispatcher.forward(request, response);

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerType customerTypeId = customerServices.selectCustomerTypeByID(Integer.parseInt(request.getParameter("idType")));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("idGender"));
        String idCard = request.getParameter("identity");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer book = new Customer(id,customerTypeId, name,birthday,gender,idCard,phone, email, address);
        customerServices.updateCustomer(book);
        request.setAttribute("message","Update successful");
        request.getRequestDispatcher("view/customer/edit_customer.jsp").forward(request,response);
//        response.sendRedirect("/customers");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));
        customerServices.deleteCustomer(id);
        request.setAttribute("message","Delete successful");
        request.getRequestDispatcher("/customers").forward(request,response);
//        response.sendRedirect("/customers");

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
    private void listCustomerUsingService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Customer> listCustomerUsingService = customerServices.selectAllCustomersUsingService();
        request.setAttribute("listCustomerUsingService", listCustomerUsingService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/test.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        CustomerType id= customerServices.selectCustomerTypeByID(Integer.parseInt(request.getParameter("idType")));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("idGender"));
        String identity = request.getParameter("identity");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,name,birthday,gender,identity,phone, email, address);
        customerServices.insertCustomer(newCustomer);
        response.sendRedirect("/customers");
    }
//
}
