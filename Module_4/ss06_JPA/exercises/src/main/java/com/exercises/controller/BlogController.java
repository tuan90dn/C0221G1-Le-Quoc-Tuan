package com.exercises.controller;

import com.exercises.model.entity.Blog;
import com.exercises.model.service.blog_service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/blogs"})
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping(value = "")
    public String index(Model model, RedirectAttributes redirectAttributes){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogs",blogList);
        redirectAttributes.addFlashAttribute("success","");
        return "/index";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return ("/create");
    }
    @PostMapping(value = "/blogs/save")
    public String saveBlog(Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/blogs/";
    }
    @GetMapping(value = "/edit/{idBlog}")
    public String showEdit(Model model, @PathVariable int idBlog){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog",blog);
        return ("edit");
    }
    @PostMapping(value = "/blogs/update")
    public String updateBlog(Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Edit Successful!");
        return "redirect:/blogs/";
    }
    @GetMapping(value = "/view/{idBlog}")
    public String showInformation(@PathVariable int idBlog,Model model){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog",blog);
        return ("view");
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
        return ("index");
    }



}
