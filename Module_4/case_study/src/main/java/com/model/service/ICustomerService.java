package com.model.service;

import com.model.entity.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer>{
    List<Customer> findCustomerByName(String name);
}
