package com.dto;

import com.model.entity.AttachService;
import com.model.entity.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ContractDetailDto {
    private Integer id;
    private Contract contract;
    private AttachService attachService;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, Contract contract, AttachService attachService, String quantity) {
        this.id = id;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
