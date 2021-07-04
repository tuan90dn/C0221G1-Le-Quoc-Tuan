package com.controller;


import com.model.entity.Blog;
import com.model.service.blog_service.IBlogService;
import com.model.service.category_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "")
    public String display(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> name){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Blog> blogList=blogService.findByName(keyword,pageable);
        model.addAttribute("blogs",blogList);
        model.addAttribute("keyword",keyword);
        model.addAttribute("success","");
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
        return "redirect:/admin";
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
        return "redirect:/admin";
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
        return "redirect:/admin";
    }
//    @PostMapping(value = "/search")
//    public String searchBlogByName(@RequestParam String name,Model model,@RequestParam(defaultValue = "0") int page){
//        Page<Blog> blogList=blogService.findByName(name,PageRequest.of(page,2));
//        model.addAttribute("blogs",blogList);
//        return ("/blog/display");
//    }



}
