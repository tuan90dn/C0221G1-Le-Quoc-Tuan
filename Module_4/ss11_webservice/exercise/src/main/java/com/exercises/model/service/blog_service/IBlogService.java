package com.exercises.model.service.blog_service;

import com.exercises.model.entity.Blog;
import com.exercises.model.service.IService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    List<Blog> findAllBlog();
    List<Blog> findBlogByCategory(Integer id);
}
