package model.repository;

import model.bean.customer_class.Customer;
import model.bean.customer_class.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer order by customer_name;";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_type_id, customer_name, customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?);";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id=?,customer_name=?," +
            "customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?," +
            "customer_address=?where customer_id=?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?;";
    private static final String SELECT_ALL_CUSTOMER_USING_SERVICE = "select * from customer where customer_id in ( select customer_id from (select contract.service_id,customer.customer_id,contract.contract_id,contract_detail.attach_service_id\n" +
            "from contract\n" +
            "join customer\n" +
            "on contract.customer_id=customer.customer_id\n" +
            "join contract_detail\n" +
            "on contract.contract_id=contract_detail.contract_id)x);";
    BaseRepository baseRepository = new BaseRepository();
    CustomerTypeRepository customerTypeRepository=new CustomerTypeRepository();

    public List<Customer> selectAllCustomers() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("customer_id");
                CustomerType customerType=customerTypeRepository.selectCustomerTypeByID(rs.getInt("customer_type_id"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id,customerType,name,birthday,gender,idCard,phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    public List<Customer> selectAllCustomersUsingService() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_USING_SERVICE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("customer_id");
                CustomerType customerType=customerTypeRepository.selectCustomerTypeByID(rs.getInt("customer_type_id"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id,customerType,name,birthday,gender,idCard,phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }


    public Customer selectCustomerByID(int id) {
        Customer customer = null;

        Connection connection = baseRepository.connectDataBase();        
        try {               
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CustomerType customerTypeId=customerTypeRepository.selectCustomerTypeByID(rs.getInt("customer_type_id"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer=new Customer(id,customerTypeId,name,birthday,gender,idCard,phone, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getCustomerType().customerTypeId);
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
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
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            preparedStatement.setInt(1, customer.getCustomerType().customerTypeId);
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public List<Customer> selectCustomerByName(String name) {
        List<Customer> listCustomer=new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();        
        try {               
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_id=rs.getInt("customer_id");
                CustomerType customerTypeId=customerTypeRepository.selectCustomerTypeByID(rs.getInt("customer_type_id"));
                String nameCustomer = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                listCustomer.add(new Customer(customer_id,customerTypeId,nameCustomer,birthday,gender,idCard,phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listCustomer;
    }
}
