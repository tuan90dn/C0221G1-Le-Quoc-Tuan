package model.bean.contract;

import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;

public class Contract {
    public int contractId;
    public String contractStartDate;
    public String contractEndDate;
    public String contractDeposit;
    public String contractTotalMoney;
    public Employee employee;
    public Customer customer;
    public Service service;
    public AttachService attachService;

    public Contract() {
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public Contract(int contractId, Employee employee,
                    Customer customer, Service service, AttachService attachService) {
        this.contractId = contractId;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.attachService = attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, String contractDeposit,
                    String contractTotalMoney, Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
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
}
