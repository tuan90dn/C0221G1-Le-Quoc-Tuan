package model.service;

import model.bean.customer_class.Customer;
import model.bean.customer_class.CustomerType;
import model.bean.service_class.RentType;
import model.bean.service_class.Service;
import model.bean.service_class.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IServiceServices {
    public List<Service> selectAllServices();
    public void insertService(Service service) throws SQLException;
    public Service selectServiceByID(int id);
    public List<Service> selectServiceByName(String name);
    public boolean deleteService(int id) throws SQLException;
    public boolean updateService(Service service) throws SQLException;
    public ServiceType selectServiceTypeByID(int id);
    public RentType selectServiceRentTypeByID(int id);
}
