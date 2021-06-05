package model.repository;

import model.bean.contract.Contract;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
import model.bean.service_class.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    BaseRepository baseRepository = new BaseRepository();
    EmployeeRepository employeeRepository=new EmployeeRepository();
    CustomerRepository customerRepository=new CustomerRepository();
    ServiceRepository serviceRepository= new ServiceRepository();
    public List<Contract> selectAllContracts() {
        Connection connection = baseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("contract_id");
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                String contractDeposit = rs.getString("contract_deposit");
                String totalMoney = rs.getString("contract_total_money");
                Employee employee = employeeRepository.selectEmployeeByID(rs.getInt("employee_id"));
                Customer customer = customerRepository.selectCustomerByID(rs.getInt("customer_id"));
                Service service = serviceRepository.selectServiceByID(rs.getInt("service_id"));
                contracts.add(new Contract(id,startDate, endDate, contractDeposit, totalMoney,employee,customer,service));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contracts;
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
