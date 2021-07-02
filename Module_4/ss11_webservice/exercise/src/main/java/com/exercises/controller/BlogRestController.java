package com.exercises.controller;

import com.exercises.model.entity.Blog;
import com.exercises.model.entity.Category;
import com.exercises.model.service.blog_service.IBlogService;
import com.exercises.model.service.category_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "/list_blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList=blogService.findAllBlog();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping(value = "/list_category")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList=categoryService.findAllCategory();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping(value = "/list_blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        Blog blog=blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping(value = "/list_blog/category/{id}")
    public ResponseEntity<List<Blog>> getListBlogByCategoryId(@PathVariable int id){
        List<Blog> blogList=blogService.findBlogByCategory(id);
        if (blogList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
