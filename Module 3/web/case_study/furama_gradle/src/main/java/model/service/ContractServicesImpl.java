package model.service;

import model.bean.Contract;

import java.sql.SQLException;
import java.util.List;

public class ContractServicesImpl implements IContractServices{

    @Override
    public List<Contract> selectAllContracts() {
        return null;
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {

    }

    @Override
    public Contract selectContractByID(int id) {
        return null;
    }

    @Override
    public List<Contract> selectContractByName(String name) {
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
