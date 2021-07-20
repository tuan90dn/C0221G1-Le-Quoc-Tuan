package model.repository;

import model.bean.customer_class.CustomerType;
import model.bean.service_class.RentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRentTypeRepo {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ServiceRentType_BY_ID = "select * from rent_type where rent_type_id=?;";
    public RentType selectServiceRentTypeByID(int id) {
        RentType serviceRentType = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ServiceRentType_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("rent_type_name");
                String cost = rs.getString("rent_type_cost");
                serviceRentType=new RentType(id,name,cost);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceRentType;
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
