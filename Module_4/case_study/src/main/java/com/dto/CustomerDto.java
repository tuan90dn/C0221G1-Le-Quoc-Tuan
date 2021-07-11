package com.dto;

import com.model.entity.Customer;
import com.model.entity.CustomerType;
import com.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto implements Validator {
    @Autowired
    private ICustomerService customerService;
    private Integer id;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^KH-[0-9]{4}$",message="Sai cmnr.KH-XXXX (X là số từ 0-9)")
    private String code;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String name;
    private CustomerType customerType;
    @NotBlank(message = "Nhập em đi anh ơi")
    @DateTimeFormat
//    @Pattern(regexp = "^([012][0-9]{1}|3[01]{1})\\/(0{1}[1-9]{1}|1[012]{1})\\/[12]{1}[0-9]{3}$")
    private String birthday;
    private Integer gender;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[0-9]{9}$|^[0-9]{12}$",message="Sai cmnr.XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^090[0-9]{7}|091[0-9]{7}|(84)+90[0-9]{7}|(84)+91[0-9]{7}$",message="Sai cmnr.090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String email;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String code, String name, CustomerType customerType, String birthday,
                       Integer gender, String idCard, String phone, String email, String address) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.customerType = customerType;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        List<Customer> customerList=customerService.findAll();
//        List<CustomerDto> customerDtoList;
//        CustomerDto customerDto= (CustomerDto) target;
//
//        for (Customer customer:customerList){
//            if (customer.getCode().equals(customerDto.code)){
//                errors.rejectValue("code","code.exist");
//            }
//        }
    }
}
