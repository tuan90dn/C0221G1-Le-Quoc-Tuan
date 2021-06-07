package model.repository;

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
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id=?;";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name=?,service_area=?," +
            "service_cost=?,service_max_people=?,rent_type_id=?,service_type_id=?,standard_room=?," +
            "description_other_convenience=?,pool_area=?,number_of_floor=? where service_id=?;";
    BaseRepository baseRepository = new BaseRepository();
    ServiceRentTypeRepo serviceRentTypeRepo = new ServiceRentTypeRepo();
    ServiceTypeRepo serviceTypeRepo = new ServiceTypeRepo();

    public List<Service> selectAllServices() {

        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                String area = rs.getString("service_area");
                String cost = rs.getString("service_cost");
                String max = rs.getString("service_max_people");
                RentType rentTypeId = serviceRentTypeRepo.selectServiceRentTypeByID(rs.getInt("rent_type_id"));
                ServiceType serviceTypeId = serviceTypeRepo.selectServiceTypeByID(rs.getInt("service_type_id"));
                String room = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberOfFloor = rs.getString("number_of_floor");

                services.add(new Service(id,name,area,cost,max,rentTypeId, serviceTypeId, room,description,poolArea,numberOfFloor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
    }
    public Service selectServiceByID(int id) {
        Service service = null;

        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("service_name");
                String area = rs.getString("service_area");
                String cost = rs.getString("service_cost");
                String max = rs.getString("service_max_people");
                RentType rentTypeId = serviceRentTypeRepo.selectServiceRentTypeByID(rs.getInt("rent_type_id"));
                ServiceType serviceTypeId = serviceTypeRepo.selectServiceTypeByID(rs.getInt("service_type_id"));
                String room = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberOfFloor = rs.getString("number_of_floor");

                service=new Service(id,name,area,cost,max,rentTypeId, serviceTypeId, room,description,poolArea,numberOfFloor);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceArea());
            preparedStatement.setString(3, service.getServiceCost());
            preparedStatement.setString(4, service.getServiceMaxPeople());
            preparedStatement.setString(5, String.valueOf(service.getRentType().rentTypeId));
            preparedStatement.setString(6, String.valueOf(service.getServiceType().serviceTypeId));
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setString(9, service.getPoolArea());
            preparedStatement.setString(9, service.getNumberOfFloor());

            rowUpdated = preparedStatement.executeUpdate() > 0;
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
}

