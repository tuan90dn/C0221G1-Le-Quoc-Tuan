package model.service;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;
import model.repository.AttachServiceRepository;
import model.repository.ContractDetailRepository;
import model.repository.ContractRepository;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServicesImpl implements IContractDetailServices {
    ContractDetailRepository contractDetailRepository=new ContractDetailRepository();
    ContractRepository contractRepository=new ContractRepository();
    AttachServiceRepository attachServiceRepository=new AttachServiceRepository();
    @Override
    public List<ContractDetail> selectAllContractDetails() {
        return contractDetailRepository.selectAllContractDetails();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {

    }

    @Override
    public ContractDetail selectContractByID(int id) {
        return null;
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return false;
    }

    @Override
    public List<Contract> selectAllContracts() {
        return contractRepository.selectAllContracts();
    }

    @Override
    public List<AttachService> selectAllAttachServices() {
        return attachServiceRepository.selectAllAttachServices();
    }

    @Override
    public ContractDetail selectContractDetailByID(int id) {
        return contractDetailRepository.selectContractDetailByID(id);
    }


}
