package model.repository;

import model.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_USER_BY_COUNTRY = "select id,name,email,country from users where country like ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_ALL_USERS_ORDER_BY_NAME = "select * from users order by name";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    BaseRepository baseRepository=new BaseRepository();

    public UserRepository() {
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Connection connection = baseRepository.connectDataBase();
        // try-with-resource statement will auto close the connection.
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }
    public User selectUserByID(int id) {
        User user = null;
        Connection connection = baseRepository.connectDataBase();
        // Step 1: Establishing a Connection
        try (
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public List<User> selectUserByCountry(String country) {

        List<User> listUser=new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        // Step 1: Establishing a Connection
        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);) {
            preparedStatement.setString(1, "%"+country+"%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id=rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String ctry = rs.getString("country");
                listUser.add(new User(id, name, email, ctry));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listUser;
    }
    public List<User> selectAllUsers() {
        Connection connection = baseRepository.connectDataBase();
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public List<User> selectAllUsersOrderByName() {
        Connection connection = baseRepository.connectDataBase();
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_ORDER_BY_NAME);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
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
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
    public User getUserById(int id) {

        User user = null;

        String query = "{CALL get_user_by_id(?)}";
        Connection connection = baseRepository.connectDataBase();

        // Step 1: Establishing a Connection

        try (

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return user;

    }
    public void insertUserStore(User user) throws SQLException {

        String query = "{CALL insert_user(?,?,?)}";
        Connection connection = baseRepository.connectDataBase();

        // try-with-resource statement will auto close the connection.

        try (

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);

        }

    }

}