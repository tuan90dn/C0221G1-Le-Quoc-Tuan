package com.model.service.blog_service;



import com.model.entity.Blog;
import com.model.service.IService;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    List<Blog> findAllBlog();
    List<Blog> findBlogByCategory(Integer id);
}
