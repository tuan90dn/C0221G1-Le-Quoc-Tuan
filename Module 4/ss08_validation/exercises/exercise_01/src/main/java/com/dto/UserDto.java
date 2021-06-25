package com.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
//    @Pattern(regexp = "(^$|[0-9]*$)",message = "bấm số á")
    private String age;

    private String phone;
    @Email(message = "Invalid format!")
    @NotBlank
    private String email;

    public UserDto() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserDto(Integer id, String firstName, String lastName, String age, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto= (UserDto) target;
        String phone=userDto.phone;
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
        String age=userDto.age;
        if (!age.matches("(^$|[0-9]*$)")){
            errors.rejectValue("age", "age.matches");
        }
    }
//    public UserDto(Integer id,@NotEmpty @Size(min = 2, max = 30) String firstName,@NotEmpty @Size(min = 2, max = 30) String lastName,
//                       @Min(18) int age,String phone,@Email String email) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.phone = phone;
//        this.email = email;
//    }


}
