package com.example.test.model.repository;

import com.example.test.model.entity.Customer;
import com.example.test.model.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
