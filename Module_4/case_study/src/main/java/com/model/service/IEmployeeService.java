package com.model.service;

import com.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IService<Employee>{
    Page<Employee> findAllByIdCardContaining (String idCard, Pageable pageable);
    Page<Employee> findAllByNameContainingAndIdCardContainingAndBirthdayContaining(String name,String idCard,String birthday,Pageable pageable);

}
