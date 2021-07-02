package com.dto;

import com.model.entity.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class ProductDto implements Validator {
    private int id;
    @NotBlank(message = "Input name đi anh!")
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d{2}",message = "Invalid form!")
    private String price;
    @NotBlank
    private String description;
    @NotBlank
    private String manufactory;
    private Date dateComment =new Date();

    private Category category;

    public ProductDto() {
    }

    public ProductDto(int id, String name, String price, String description, String manufactory,
                      Date dateComment, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactory = manufactory;
        this.dateComment = dateComment;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
