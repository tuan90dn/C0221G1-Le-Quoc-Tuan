package com.model.repository;

import com.model.entity.Customer;
import com.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    @Query(value = "select * from employee where name like :name and is_active=true ",nativeQuery = true)
    Page<Employee> findEmployeesByName(@Param("name") String name, Pageable pageable);

    Page<Employee> findAllByNameContainingAndIdCardContaining(String name,String idCard,Pageable pageable);

    Page<Employee> findAllByIdCardContaining (String idCard,Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update employee set is_active=false where id = :id",nativeQuery = true)
    void deleteByFlag(@Param("id") Integer id);
}
