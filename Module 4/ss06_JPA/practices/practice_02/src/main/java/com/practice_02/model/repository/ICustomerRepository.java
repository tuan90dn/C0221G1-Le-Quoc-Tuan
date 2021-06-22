package com.practice_02.model.repository;

import com.practice_02.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Procedure("Insert_Customer")
    void insertWithStoredProcedure(@Param("first_name") String firstName,@Param("last_name") String lastName);
}
