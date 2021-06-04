package model.repository;

import model.bean.customer_class.Customer;
import model.bean.customer_class.CustomerType;
import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee order by employee_name;";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id=?;";
    BaseRepository baseRepository = new BaseRepository();
    EmployeePositionRepo employeePositionRepo=new EmployeePositionRepo();
    EmployeeEducationDegreeRepo employeeEducationDegreeRepo=new EmployeeEducationDegreeRepo();
    EmployeeDivisionRepo employeeDivisionRepo=new EmployeeDivisionRepo();

    public List<Employee> selectAllEmployees() {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String address = rs.getString("employee_address");
                EmployeePosition position_id = employeePositionRepo.selectEmployeePositionByID(rs.getInt("position_id"));
                EmployeeEducationDegree education_degree_id = employeeEducationDegreeRepo.selectEmployeeEducationDegreeByID(rs.getInt("education_degree_id"));
                EmployeeDivision division_id = employeeDivisionRepo.selectEmployeeDivisionByID(rs.getInt("division_id"));
                employees.add(new Employee(id,name, birthday, address, position_id,education_degree_id,division_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }
    public Employee selectEmployeeByID(int id) {
        Employee employee = null;

        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String id_card = rs.getString("employee_id_card");
                String salary = rs.getString("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                EmployeePosition position_id = employeePositionRepo.selectEmployeePositionByID(rs.getInt("position_id"));
                EmployeeEducationDegree education_degree_id = employeeEducationDegreeRepo.selectEmployeeEducationDegreeByID(rs.getInt("education_degree_id"));
                EmployeeDivision division_id = employeeDivisionRepo.selectEmployeeDivisionByID(rs.getInt("division_id"));
                String username = rs.getString("username");
                employee=new Employee(id,name,birthday,id_card,salary,phone, email, address,position_id,education_degree_id,division_id,username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setString(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id().position_id);
            preparedStatement.setInt(9, employee.getEducation_degree_id().education_degree_id);
            preparedStatement.setInt(10, employee.getDivision_id().division_id);
            preparedStatement.setString(11, employee.getUsername());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
