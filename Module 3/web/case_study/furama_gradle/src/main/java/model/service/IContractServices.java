package model.service;

import model.bean.contract.Contract;

import java.sql.SQLException;
import java.util.List;

public interface IContractServices {
    public List<Contract> selectAllContracts();
    public void insertContract(Contract contract) throws SQLException;
    public Contract selectContractByID(int id);
    public boolean deleteContract(int id) throws SQLException;
    public boolean updateContract(Contract contract) throws SQLException;

}
