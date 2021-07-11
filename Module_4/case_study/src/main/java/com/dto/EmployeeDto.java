package com.dto;

import com.model.entity.AppUser;
import com.model.entity.Division;
import com.model.entity.EducationDegree;
import com.model.entity.Position;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer id;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String name;
    @DateTimeFormat
    private String birthday;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[0-9]{9}$|^[0-9]{12}$",message="Sai cmnr.XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^[1-9]\\d*$",message = "Lương phải là số dương")
    private String salary;
    @NotBlank(message = "Nhập em đi anh ơi")
    @Pattern(regexp = "^090[0-9]{7}|091[0-9]{7}|(84)+90[0-9]{7}|(84)+91[0-9]{7}$",message="Sai cmnr.090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String email;
    @NotBlank(message = "Nhập em đi anh ơi")
    private String address;
    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    private AppUser appUser;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String birthday, String idCard, String salary,
                       String phone, String email, String address, Position position,
                       EducationDegree educationDegree, Division division, AppUser appUser) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.appUser = appUser;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
