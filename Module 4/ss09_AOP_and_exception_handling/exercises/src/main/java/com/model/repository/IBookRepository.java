package com.model.repository;

import com.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
//    @Query(value = "select * from book_table where name like :name",nativeQuery = true)
//    Page<Book> findBookByName(@Param("name")String name, Pageable pageable);
}
