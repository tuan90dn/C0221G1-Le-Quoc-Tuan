package com.model.repository;

import com.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;



public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
    @Query(value = "select * from category_table where name like :name",nativeQuery = true)
    Page<Category> findCategoryByName(@Param("name") String name, Pageable pageable);
}
