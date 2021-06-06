package model.repository;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
import model.bean.service_class.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "select * from contract_detail where contract_detail_id=?";
    BaseRepository baseRepository = new BaseRepository();
    AttachServiceRepository attachServiceRepository=new AttachServiceRepository();
    ContractRepository contractRepository=new ContractRepository();
    public List<ContractDetail> selectAllContractDetails() {
        Connection connection = baseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int contractDetailId=rs.getInt("contract_detail_id");
                Contract contract = contractRepository.selectContractByID(rs.getInt("contract_id"));
                AttachService attachService = attachServiceRepository.selectAttachServiceByID(rs.getInt("attach_service_id"));
                int quantity = rs.getInt("quantity");
                contractDetails.add(new ContractDetail(contractDetailId,contract,attachService,quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetails;
    }
    public ContractDetail selectContractDetailByID(int id) {
        Connection connection = baseRepository.connectDataBase();
        ContractDetail contractDetail = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Contract contract = contractRepository.selectContractByID(rs.getInt("contract_id"));
                AttachService attachService = attachServiceRepository.selectAttachServiceByID(rs.getInt("attach_service_id"));
                int quantity = rs.getInt("quantity");
                contractDetail=new ContractDetail(id,contract, attachService, quantity);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetail;
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
