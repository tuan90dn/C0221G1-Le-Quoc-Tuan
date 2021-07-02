package com.model.repository;

import com.model.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
    @Query(value = "select * from borrow_book where code_borrow = :code",nativeQuery = true)
    BorrowBook findBorrowBookByCode(@Param("code")String code);
}
