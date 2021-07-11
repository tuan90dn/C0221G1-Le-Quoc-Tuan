package com.model.repository;

import com.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    @Query(value = "select * from customer where name like :name and is_active=true ",nativeQuery = true)
    Page<Customer> findCustomersByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from customer where name like :name and is_active=true",nativeQuery = true)
    List<Customer> findListCustomerByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "update customer set is_active=false where id = :id",nativeQuery = true)
    void deleteByFlag(@Param("id") Integer id);
}
