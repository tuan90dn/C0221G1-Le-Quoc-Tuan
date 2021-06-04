package model.service;

import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
import model.repository.EmployeeDivisionRepo;
import model.repository.EmployeeEducationDegreeRepo;
import model.repository.EmployeePositionRepo;
import model.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServicesImpl implements IEmployeeServices {
    EmployeeRepository employeeRepository=new EmployeeRepository();
    EmployeePositionRepo employeePositionRepo=new EmployeePositionRepo();
    EmployeeEducationDegreeRepo employeeEducationDegreeRepo=new EmployeeEducationDegreeRepo();
    EmployeeDivisionRepo employeeDivisionRepo=new EmployeeDivisionRepo();

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployeeByID(int id) {
        return employeeRepository.selectEmployeeByID(id);
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) {
        return employeeRepository.selectEmployeeByName(name);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public EmployeePosition selectEmployeePositionByID(int id) {
        return employeePositionRepo.selectEmployeePositionByID(id);
    }

    @Override
    public EmployeeEducationDegree selectEmployeeEducationDegreeByID(int id) {
        return employeeEducationDegreeRepo.selectEmployeeEducationDegreeByID(id);
    }

    @Override
    public EmployeeDivision selectEmployeeDivisionByID(int id) {
        return employeeDivisionRepo.selectEmployeeDivisionByID(id);
    }
}
