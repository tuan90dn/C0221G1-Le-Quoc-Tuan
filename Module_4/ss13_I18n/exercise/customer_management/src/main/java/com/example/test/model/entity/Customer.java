package com.example.test.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "province_id",referencedColumnName = "id")
    private Province provinceCustomer;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Integer id, String firstName, String lastName, Province provinceCustomer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provinceCustomer = provinceCustomer;
    }

    public Province getProvinceCustomer() {
        return provinceCustomer;
    }

    public void setProvinceCustomer(Province provinceCustomer) {
        this.provinceCustomer = provinceCustomer;
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
