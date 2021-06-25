package com.dto;

import com.model.entity.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProductDto implements Validator {
    private int id;
    @NotBlank
    private String name;
    private String price;
    private String description;
    private String manufactory;
    private Date dateComment =new Date();

    private Category category;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
