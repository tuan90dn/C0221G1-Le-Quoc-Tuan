package com.exercises.model.repository;

import com.exercises.model.entity.Blog;
import com.exercises.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
    @Query(value = "select * from category_table where name like :name",nativeQuery = true)
    Page<Category> findCategoryByName(@Param("name") String name, Pageable pageable);
}
