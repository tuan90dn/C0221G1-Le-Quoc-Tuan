package com.model.service.implement;

import com.model.entity.Customer;
import com.model.repository.ICustomerRepository;
import com.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {
        customerRepository.deleteByFlag(id);
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return customerRepository.findCustomersByName("%"+name+"%",pageable);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findListCustomerByName("%"+name+"%");
    }
}
