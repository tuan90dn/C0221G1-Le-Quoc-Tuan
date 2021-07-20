package model.repository;


import model.bean.service_class.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRepo {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ServiceType_BY_ID = "select * from service_type where service_type_id=?;";
    public ServiceType selectServiceTypeByID(int id) {
        ServiceType serviceType = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ServiceType_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("service_type_name");
                serviceType=new ServiceType(id,name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceType;
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
