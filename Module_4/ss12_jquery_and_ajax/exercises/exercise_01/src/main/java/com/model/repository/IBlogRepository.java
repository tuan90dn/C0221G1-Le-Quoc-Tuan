package com.model.repository;

import com.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    @Query(value = "select * from blog_table where name like :name order by date_comment desc ",nativeQuery = true)
    Page<Blog> findBlogByName(@Param("name") String name, Pageable pageable);
    @Query(value = "select * from blog_table where category_id = :id ",nativeQuery = true)
    List<Blog> findBlogByCategory(@Param("id") Integer id);
    @Query(value = "select * from blog_table where name like :name order by date_comment desc ",nativeQuery = true)
    List<Blog> findListBlogByName(@Param("name") String name);
    @Query(value = "select * from blog_table order by date_comment desc ",nativeQuery = true)
    Page<Blog> getPageBlog(Pageable pageable);

}
