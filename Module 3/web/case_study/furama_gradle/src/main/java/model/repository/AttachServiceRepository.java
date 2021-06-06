package model.repository;

import model.bean.contract.AttachService;
import model.bean.customer_class.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository {
    private static final String SELECT_ATTACH_SERVICE = "select * from attach_service";
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ATTACH_SERVICE_BY_ID = "select * from attach_service where attach_service_id=?;";
    public List<AttachService> selectAllAttachServices() {
        List<AttachService> attachServiceList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int attachServiceId=rs.getInt("attach_service_id");
                String attachServiceName = rs.getString("attach_service_name");
                String attachServiceCost = rs.getString("attach_service_cost");
                int attachServiceUnit = rs.getInt("attach_service_unit");
                String attachServiceStatus = rs.getString("attach_service_status");
                attachServiceList.add(new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return attachServiceList;
    }
    public AttachService selectAttachServiceByID(int id) {
        AttachService attachService = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String attachServiceName = rs.getString("attach_service_name");
                String attachServiceCost = rs.getString("attach_service_cost");
                int attachServiceUnit = rs.getInt("attach_service_unit");
                String attachServiceStatus = rs.getString("attach_service_status");

                attachService=new AttachService(id,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return attachService;
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
