package com.exercises.controller;

import com.exercises.model.entity.Blog;
import com.exercises.model.service.blog_service.IBlogService;
import com.exercises.model.service.index_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "")
    public String display(Model model, RedirectAttributes redirectAttributes,@RequestParam(defaultValue = "0") int page){
        Page<Blog> blogList=blogService.findAll(PageRequest.of(page,2));
        model.addAttribute("blogs",blogList);
        redirectAttributes.addFlashAttribute("success","");
        return "/blog/display";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",this.categoryService.findAllCategory());
        return ("/blog/create");
    }
    @PostMapping(value = "/save")
    public String saveBlog(Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/blogs/";
    }
    @GetMapping(value = "/edit/{idBlog}")
    public String showEdit(Model model, @PathVariable int idBlog){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog",blog);
        model.addAttribute("category",this.categoryService.findAllCategory());
        return ("/blog/edit");
    }
    @PostMapping(value = "/update")
    public String updateBlog(Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Edit Successful!");
        return "redirect:/blogs/";
    }
    @GetMapping(value = "/view/{idBlog}")
    public String showInformation(@PathVariable int idBlog,Model model){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog",blog);
        return ("/blog/view");
    }
    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam int idBlog, RedirectAttributes redirectAttributes){
        blogService.remove(idBlog);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/blogs/";
    }
    @PostMapping(value = "/search")
    public String searchBlogByName(@RequestParam String name,Model model){
        List<Blog> blogList=blogService.findByName(name);
        model.addAttribute("blogs",blogList);
        return ("/blog/display");
    }



}
