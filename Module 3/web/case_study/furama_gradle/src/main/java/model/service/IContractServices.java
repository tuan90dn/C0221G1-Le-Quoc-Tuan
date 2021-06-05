package model.service;

import model.bean.Contract;
import model.bean.service_class.RentType;
import model.bean.service_class.Service;
import model.bean.service_class.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IContractServices {
    public List<Contract> selectAllContracts();
    public void insertContract(Contract contract) throws SQLException;
    public Contract selectContractByID(int id);
    public List<Contract> selectContractByName(String name);
    public boolean deleteContract(int id) throws SQLException;
    public boolean updateContract(Contract contract) throws SQLException;

}
