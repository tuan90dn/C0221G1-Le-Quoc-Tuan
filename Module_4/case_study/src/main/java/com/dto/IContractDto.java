package com.dto;

import com.model.entity.Customer;
import com.model.entity.Employee;
import com.model.entity.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public interface IContractDto {
    Integer getId();
    String getDateStart();
    String getDateEnd();
    String getDeposit();
    String getListServices();
    String getTotalMoney();

    String getEmployeeName();

    String getCustomerName();

    String getServiceName();

}
