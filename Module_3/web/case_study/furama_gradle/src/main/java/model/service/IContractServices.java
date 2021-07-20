package model.service;

import model.bean.contract.Contract;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;

import java.sql.SQLException;
import java.util.List;

public interface IContractServices {
    public List<Contract> selectAllContracts();
    public void insertContract(Contract contract) throws SQLException;
    public Contract selectContractByID(int id);
    public boolean deleteContract(int id) throws SQLException;
    public boolean updateContract(Contract contract) throws SQLException;
    public List<Customer> selectAllCustomers();
    public List<Employee> selectAllEmployees();
    public List<Service> selectAllServices();
    public List<Contract> selectAllCustomerUsingService();
}
