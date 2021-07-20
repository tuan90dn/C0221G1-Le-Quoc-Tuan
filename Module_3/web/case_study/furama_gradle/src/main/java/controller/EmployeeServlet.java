package controller;

import model.bean.customer_class.Customer;
import model.bean.customer_class.CustomerType;
import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
import model.service.EmployeeServicesImpl;
import model.service.IEmployeeServices;
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

@WebServlet(name = "EmployeeServlet",value = "/employees")
public class EmployeeServlet extends HttpServlet {
    IEmployeeServices employeeServices;
    public void init(){
        employeeServices=new EmployeeServicesImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "search":
                    searchEmployeeByName(request,response);
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
                    showInformationOfEmployee(request, response);
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

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/employee/search_employee.jsp").forward(request,response);
    }
    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        List<Employee> listEmployee=employeeServices.selectEmployeeByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/show_search_employee.jsp");
        request.setAttribute("listEmployee", listEmployee);
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = employeeServices.selectEmployeeByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit_employee.jsp");
        request.setAttribute("employee", existingUser);
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));
        employeeServices.deleteEmployee(id);
        response.sendRedirect("/employees");
    }
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        EmployeePosition idPosition = employeeServices.selectEmployeePositionByID(Integer.parseInt(request.getParameter("idPosition")));
        EmployeeEducationDegree idEducation = employeeServices.selectEmployeeEducationDegreeByID(Integer.parseInt(request.getParameter("idEducation")));
        EmployeeDivision idDivision = employeeServices.selectEmployeeDivisionByID(Integer.parseInt(request.getParameter("idDivision")));
        String userName = request.getParameter("username");

        Employee book = new Employee(id,name,birthday,idCard,salary,phone, email, address,idPosition,idEducation,idDivision,userName);
        employeeServices.updateEmployee(book);
        response.sendRedirect("/employees");
    }



    private void showInformationOfEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeServices.selectEmployeeByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/show_information.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployeeOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Employee> listEmployee = employeeServices.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
        dispatcher.forward(request, response);
    }
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        EmployeePosition idPosition = employeeServices.selectEmployeePositionByID(Integer.parseInt(request.getParameter("idPosition")));
        EmployeeEducationDegree idEducation = employeeServices.selectEmployeeEducationDegreeByID(Integer.parseInt(request.getParameter("idEducation")));
        EmployeeDivision idDivision = employeeServices.selectEmployeeDivisionByID(Integer.parseInt(request.getParameter("idDivision")));
        String userName = request.getParameter("username");
        Employee newEmployee = new Employee(name,birthday,idCard,salary,phone, email, address,idPosition,idEducation,idDivision,userName);
        employeeServices.insertEmployee(newEmployee);
        response.sendRedirect("/employees");
    }

}
