package com.exercises.model.repository;

import com.exercises.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    @Query(value = "select * from blog_table where name like %?1%",nativeQuery = true)
    Page<Blog> findBlogByName(@Param("name") String name, Pageable pageable);
}
