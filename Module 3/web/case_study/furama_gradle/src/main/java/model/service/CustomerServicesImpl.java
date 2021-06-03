package model.service;

import model.bean.Customer;
import model.bean.CustomerType;
import model.repository.CustomerRepository;
import model.repository.CustomerTypeRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerServicesImpl implements ICustomerServices {
    CustomerRepository customerRepository=new CustomerRepository();
    CustomerTypeRepository customerTypeRepository=new CustomerTypeRepository();
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public Customer selectCustomerByID(int id) {
        return customerRepository.selectCustomerByID(id);
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        return customerRepository.selectCustomerByName(name);
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public CustomerType selectCustomerTypeByID(int id) {
        return customerTypeRepository.selectCustomerTypeByID(id);
    }
}
