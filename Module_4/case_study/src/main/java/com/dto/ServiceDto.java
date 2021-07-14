package com.dto;

import com.model.entity.RentType;
import com.model.entity.ServiceType;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Integer id;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String name;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String area;
    @NotNull(message = "Nhập em đi anh ơi")
    @NumberFormat(pattern = "^[1-9]\\d*$")
    private Long cost;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String maxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String standardRoom;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String descriptionOtherConvenience;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String poolArea;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Số dương anh ơi")
    private String numberOfFloors;

    public ServiceDto() {
    }

    public ServiceDto(Integer id, String name, String area, Long cost, String maxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
