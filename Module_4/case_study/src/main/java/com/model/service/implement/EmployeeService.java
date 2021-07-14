package com.model.service.implement;

import com.model.entity.Employee;
import com.model.repository.IEmployeeRepository;
import com.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {
        employeeRepository.deleteByFlag(id);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.findEmployeesByName("%"+name+"%",pageable);
    }

    @Override
    public Page<Employee> findAllByIdCardContaining(String idCard, Pageable pageable) {
        return employeeRepository.findAllByIdCardContaining(idCard,pageable);
    }

    @Override
    public Page<Employee> findAllByNameContainingAndIdCardContainingAndBirthdayContaining(String name, String idCard,String birthday, Pageable pageable) {
        return employeeRepository.findAllByNameContainingAndIdCardContainingAndBirthdayContaining(name,idCard,birthday,pageable);
    }
}
