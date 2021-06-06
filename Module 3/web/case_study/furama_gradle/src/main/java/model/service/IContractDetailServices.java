package model.service;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailServices {
    public List<ContractDetail> selectAllContractDetails();
    public void insertContract(Contract contract) throws SQLException;
    public ContractDetail selectContractByID(int id);
    public boolean deleteContract(int id) throws SQLException;
    public boolean updateContract(Contract contract) throws SQLException;
    public List<Contract> selectAllContracts();
    public List<AttachService> selectAllAttachServices();
    public ContractDetail selectContractDetailByID(int id);

}
