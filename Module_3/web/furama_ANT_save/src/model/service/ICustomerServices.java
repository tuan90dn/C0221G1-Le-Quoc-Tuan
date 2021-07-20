package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerServices {
    public List<Customer> selectAllCustomers();
    public void insertCustomer(Customer customer) throws SQLException;
    public Customer selectUserByID(int id);
    public List<Customer> searchUserByName(String country);
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(Customer customer) throws SQLException;
}
