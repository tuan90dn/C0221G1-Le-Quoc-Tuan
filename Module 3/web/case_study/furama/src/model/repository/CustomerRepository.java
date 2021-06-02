package model.repository;

import model.bean.Customer;

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
    private static final String DELETE_USERS_SQL = "delete from customer where customer_id = ?;";
    BaseRepository baseRepository = new BaseRepository();

    public List<Customer> selectAllCustomers() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                String phone = rs.getString("customer_phone");
                customers.add(new Customer(id,name, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        Connection connection = baseRepository.connectDataBase();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_birthday());
            preparedStatement.setInt(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
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
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
