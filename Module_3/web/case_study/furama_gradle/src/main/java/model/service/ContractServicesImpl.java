package model.service;

import model.bean.contract.Contract;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;
import model.repository.ContractRepository;
import model.repository.CustomerRepository;
import model.repository.EmployeeRepository;
import model.repository.ServiceRepository;

import java.sql.SQLException;
import java.util.List;

public class ContractServicesImpl implements IContractServices{
    ContractRepository contractRepository=new ContractRepository();
    CustomerRepository customerRepository=new CustomerRepository();
    EmployeeRepository employeeRepository=new EmployeeRepository();
    ServiceRepository serviceRepository=new ServiceRepository();

    @Override
    public List<Contract> selectAllContracts() {
        return contractRepository.selectAllContracts();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {

    }

    @Override
    public Contract selectContractByID(int id) {
        return contractRepository.selectContractByID(id);
    }


    @Override
    public boolean deleteContract(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public List<Service> selectAllServices() {
        return serviceRepository.selectAllServices();
    }

    @Override
    public List<Contract> selectAllCustomerUsingService() {
        return contractRepository.selectAllCustomerUsingService();
    }
}
