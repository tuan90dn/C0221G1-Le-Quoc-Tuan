package model.repository;

import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeEducationDegreeRepo {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EmployeeEducationDegree_BY_ID = "select * from education_degree where education_degree_id=?;";
    public EmployeeEducationDegree selectEmployeeEducationDegreeByID(int id) {
        EmployeeEducationDegree employeeEducationDegree = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EmployeeEducationDegree_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("education_degree_name");
                employeeEducationDegree =new EmployeeEducationDegree(id,name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeEducationDegree;
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
