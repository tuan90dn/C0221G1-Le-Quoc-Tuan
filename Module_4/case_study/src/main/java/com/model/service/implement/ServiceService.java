package com.model.service.implement;

import com.model.entity.Service;
import com.model.repository.IServiceRepository;
import com.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public List<Service> findAll() {
        return (List<Service>) serviceRepository.findAll();
    }

    @Override
    public Service findById(Integer id) {
        return null;
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<Service> findByName(String name, Pageable pageable) {
        return serviceRepository.findServicesByName("%"+name+"%",pageable);
    }
}
