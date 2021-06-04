package model.service;

import model.bean.employee_class.Employee;
import model.bean.employee_class.EmployeeDivision;
import model.bean.employee_class.EmployeeEducationDegree;
import model.bean.employee_class.EmployeePosition;
import model.bean.service_class.RentType;
import model.bean.service_class.Service;
import model.bean.service_class.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeServices {
    public List<Employee> selectAllEmployees();
    public void insertEmployee(Employee employee) throws SQLException;
    public Employee selectEmployeeByID(int id);
    public List<Employee> selectEmployeeByName(String name);
    public boolean deleteEmployee(Employee id) throws SQLException;
    public boolean updateEmployee(Employee employee) throws SQLException;
    public EmployeePosition selectEmployeePositionByID(int id);
    public EmployeeEducationDegree selectEmployeeEducationDegreeByID(int id);
    public EmployeeDivision selectEmployeeDivisionByID(int id);
}
