package com.model.repository;

import com.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
    @Query(value = "select * from category_table where name like :name and is_active=true",nativeQuery = true)
    Page<Category> findCategoryByName(@Param("name") String name, Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "update category_table set is_active=false where id = :idCategory",nativeQuery = true)
    void deleteByFlag(@Param("idCategory") Integer idCategory);

    @Query(value = "select * from category_table where is_active=true",nativeQuery = true)
    List<Category> findAllCategoryActive();
}
