package model.service;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerServicesImpl implements ICustomerServices {
    CustomerRepository customerRepository=new CustomerRepository();
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public Customer selectUserByID(int id) {
        return null;
    }

    @Override
    public List<Customer> searchUserByName(String country) {
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return customerRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        return false;
    }
}
