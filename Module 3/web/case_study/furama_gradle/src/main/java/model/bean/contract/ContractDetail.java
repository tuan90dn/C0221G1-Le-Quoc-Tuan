package model.bean.contract;

import model.bean.customer_class.Customer;
import model.bean.employee_class.Employee;
import model.bean.service_class.Service;

public class ContractDetail {
    public int contract_detail_id;
    public Contract contract_id;
    public AttachService attach_service_id;
    public int quantity;
    public Employee employee_id;
    public Customer customer_id;
    public Service service_id;

    public ContractDetail(int contract_detail_id, Contract contract_id, AttachService attach_service_id, int quantity, Employee employee_id, Customer customer_id, Service service_id) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Service getService_id() {
        return service_id;
    }

    public void setService_id(Service service_id) {
        this.service_id = service_id;
    }

    public ContractDetail() {
    }

    public ContractDetail(int contract_detail_id, Contract contract_id, AttachService attach_service_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract_id() {
        return contract_id;
    }

    public void setContract_id(Contract contract_id) {
        this.contract_id = contract_id;
    }

    public AttachService getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(AttachService attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
