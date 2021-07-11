package com.model.service.implement;

import com.model.entity.CustomerType;
import com.model.repository.ICustomerTypeRepository;
import com.model.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return null;
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<CustomerType> findByName(String name, Pageable pageable) {
        return null;
    }
}
