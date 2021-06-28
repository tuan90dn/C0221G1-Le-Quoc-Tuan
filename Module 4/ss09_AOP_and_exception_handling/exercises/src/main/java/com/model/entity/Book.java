package com.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer number;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<BorrowBook> code;

    public Book() {
    }


    public Set<BorrowBook> getCode() {
        return code;
    }

    public void setCode(Set<BorrowBook> code) {
        this.code = code;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
