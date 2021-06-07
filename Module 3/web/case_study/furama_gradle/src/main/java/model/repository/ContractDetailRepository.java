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
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail;";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "select * from contract_detail where contract_detail_id=?;";
    private static final String SELECT_ALL_CONTRACT_DETAIL_USING_SERVICE = "select cd.contract_detail_id,ct.customer_id,cd.contract_id, cd.attach_service_id,ct.service_id,ct.employee_id,cd.quantity\n" +
            "from contract_detail cd\n" +
            "join contract ct\n" +
            "on ct.contract_id=cd.contract_id\n" +
            "join customer ctm\n" +
            "on ct.customer_id=ctm.customer_id\n" +
            "join attach_service ats\n" +
            "on ats.attach_service_id=cd.attach_service_id;";
    BaseRepository baseRepository = new BaseRepository();
    AttachServiceRepository attachServiceRepository=new AttachServiceRepository();
    ContractRepository contractRepository=new ContractRepository();
    EmployeeRepository employeeRepository=new EmployeeRepository();
    CustomerRepository customerRepository=new CustomerRepository();
    ServiceRepository serviceRepository= new ServiceRepository();
    public List<ContractDetail> selectAllContractDetails() {
        Connection connection = baseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
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
    public List<ContractDetail> selectAllContractDetailsUsingService() {
        Connection connection = baseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL_USING_SERVICE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int contractDetailId=rs.getInt("contract_detail_id");
                Contract contract = contractRepository.selectContractByID(rs.getInt("contract_id"));
                AttachService attachService = attachServiceRepository.selectAttachServiceByID(rs.getInt("attach_service_id"));
                int quantity = rs.getInt("quantity");
//                Employee employee = employeeRepository.selectEmployeeByID(rs.getInt("employee_id"));
//                Customer customer = customerRepository.selectCustomerByID(rs.getInt("customer_id"));
//                Service service = serviceRepository.selectServiceByID(rs.getInt("service_id"));
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
