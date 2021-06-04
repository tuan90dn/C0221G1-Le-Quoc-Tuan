package model.repository;

import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDivisionRepo {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EmployeeDivision_BY_ID = "select * from division where division_id=?;";
    public EmployeeDivision selectEmployeeDivisionByID(int id) {
        EmployeeDivision employeeDivision = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EmployeeDivision_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("division_name");
                employeeDivision =new EmployeeDivision(id,name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeDivision;
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
