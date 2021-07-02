package com.practice_02.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
//@NamedStoredProcedureQuery(name = "Customer.Insert_Customer",
//        procedureName = "Insert_Customer", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "first_name", type = String.class),
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "last_name", type = String.class)})
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
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
}
