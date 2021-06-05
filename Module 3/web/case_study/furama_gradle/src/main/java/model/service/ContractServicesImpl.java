package model.service;

import model.bean.contract.Contract;
import model.repository.ContractRepository;

import java.sql.SQLException;
import java.util.List;

public class ContractServicesImpl implements IContractServices{
    ContractRepository contractRepository=new ContractRepository();

    @Override
    public List<Contract> selectAllContracts() {
        return contractRepository.selectAllContracts();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {

    }

    @Override
    public Contract selectContractByID(int id) {
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
}
