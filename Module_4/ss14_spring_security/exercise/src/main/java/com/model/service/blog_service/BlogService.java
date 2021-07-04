package com.model.service.blog_service;


import com.model.entity.Blog;
import com.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByName(String name,Pageable pageable) {
        return blogRepository.findBlogByName("%"+name+"%",pageable);
    }

    @Override
    public List<Blog> findAllBlog() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public List<Blog> findBlogByCategory(Integer id) {
        return blogRepository.findBlogByCategory(id);
    }
}
