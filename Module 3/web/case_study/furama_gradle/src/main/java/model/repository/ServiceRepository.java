package model.repository;

import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
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
                RentType rentTypeId = serviceRentTypeRepo.selectServiceRentTypeByID(rs.getInt("rent_type_id"));
                ServiceType serviceTypeId = serviceTypeRepo.selectServiceTypeByID(rs.getInt("service_type_id"));
                String numberOfFloor = rs.getString("number_of_floor");
                services.add(new Service(id, name, rentTypeId, serviceTypeId, numberOfFloor));
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
