package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerServices {
    public List<Customer> selectAllCustomers();
    public void insertCustomer(Customer customer) throws SQLException;
    public Customer selectCustomerByID(int id);
    public List<Customer> selectCustomerByName(String name);
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
}
