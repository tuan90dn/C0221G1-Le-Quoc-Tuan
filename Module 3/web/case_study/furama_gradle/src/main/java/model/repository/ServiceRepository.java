package model.repository;

import model.bean.customer_class.Customer;
import model.bean.service_class.RentType;
import model.bean.service_class.Service;
import model.bean.service_class.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select * from service order by service_name;";
    BaseRepository baseRepository = new BaseRepository();
    ServiceRentTypeRepo serviceRentTypeRepo = new ServiceRentTypeRepo();
    ServiceTypeRepo serviceTypeRepo = new ServiceTypeRepo();

    public List<Service> selectAllCustomers() {

        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                RentType rent_type_id = serviceRentTypeRepo.selectServiceRentTypeByID(rs.getInt("rent_type_id"));
                ServiceType service_type_id = serviceTypeRepo.selectServiceTypeByID(rs.getInt("service_type_id"));
                String number_of_floor = rs.getString("number_of_floor");
                services.add(new Service(id, name, rent_type_id, service_type_id, number_of_floor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;

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

