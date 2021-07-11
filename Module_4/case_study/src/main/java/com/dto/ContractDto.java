package com.dto;

import com.model.entity.Customer;
import com.model.entity.Employee;
import com.model.entity.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Calendar;

public class ContractDto {
    private Integer id;
    @NotBlank(message = "Nhập em đi anh ơi")
    @DateTimeFormat
    private String startDate;
    @DateTimeFormat
    @NotBlank(message = "Nhập em đi anh ơi")
    private String endDate;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String deposit;
    private String listServices;
//    @NotBlank(message = "Nhập em đi anh ơi")
//    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private Long totalMoney=null;

    private Employee employee;

    private Customer customer;

    private Service service;

    public ContractDto() {
    }

    public String getListServices() {
        return listServices;
    }

    public void setListServices(String listServices) {
        this.listServices = listServices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    public static Long daysBetween2Date(String start,String end){

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        // Định nghĩa 2 mốc thời gian ban đầu
        Date date1 = Date.valueOf(start);
        Date date2 = Date.valueOf(end);

        c1.setTime(date1);
        c2.setTime(date2);
        Long numDay=(c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        return numDay;
    }
}
