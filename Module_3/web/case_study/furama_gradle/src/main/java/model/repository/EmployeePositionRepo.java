package model.repository;

import model.bean.employee_class.EmployeePosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePositionRepo {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EmployeePosition_BY_ID = "select * from `position` where position_id=?;";
    public EmployeePosition selectEmployeePositionByID(int id) {
        EmployeePosition employeePosition = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EmployeePosition_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("position_name");
                employeePosition =new EmployeePosition(id,name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeePosition;
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
