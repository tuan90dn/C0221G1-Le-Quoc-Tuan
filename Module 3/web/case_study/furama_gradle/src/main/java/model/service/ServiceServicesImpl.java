package model.service;

import model.bean.service_class.RentType;
import model.bean.service_class.Service;
import model.bean.service_class.ServiceType;
import model.repository.ServiceRepository;

import java.sql.SQLException;
import java.util.List;

public class ServiceServicesImpl implements IServiceServices {
    ServiceRepository serviceRepository=new ServiceRepository();

    @Override
    public List<Service> selectAllServices() {
        return serviceRepository.selectAllCustomers();
    }

    @Override
    public void insertService(Service service) throws SQLException {

    }

    @Override
    public Service selectServiceByID(int id) {
        return null;
    }

    @Override
    public List<Service> selectServiceByName(String name) {
        return null;
    }

    @Override
    public boolean deleteService(Service id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return false;
    }

    @Override
    public ServiceType selectServiceTypeByID(int id) {
        return null;
    }

    @Override
    public RentType selectServiceRentTypeByID(int id) {
        return null;
    }
}
