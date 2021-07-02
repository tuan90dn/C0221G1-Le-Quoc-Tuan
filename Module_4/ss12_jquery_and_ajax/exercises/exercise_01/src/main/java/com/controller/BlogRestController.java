package com.controller;

import com.model.entity.Blog;
import com.model.entity.Category;
import com.model.service.blog_service.IBlogService;
import com.model.service.category_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/blogRest")
@RestController
@CrossOrigin
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
    @GetMapping(value = "/page_blog")
    public ResponseEntity<Page<Blog>> getPageBlog(@RequestParam int page){
        Page<Blog> blogPage= blogService.findAll(PageRequest.of(page,2));
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
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
    @GetMapping(value = "/search")
    public ResponseEntity<List<Blog>> searchBlogByName(@RequestParam String name){
        List<Blog> blogList=blogService.findListBlogByName(name);
        if (blogList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
