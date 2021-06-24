package com.controller;


import com.model.entity.Category;
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
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "")
    public String display(Model model, @RequestParam Optional<String> name, @PageableDefault(size = 2)Pageable pageable){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Category> categoryList =categoryService.findByName(keyword,pageable);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("success","");
        return "/category/display";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return ("/category/create");
    }
    @PostMapping(value = "/save")
    public String saveCategory(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/category/";
    }
    @GetMapping(value = "/edit/{idCategory}")
    public String showEdit(Model model, @PathVariable int idCategory){
        Category category = categoryService.findById(idCategory);
        model.addAttribute("category", category);
        return ("/category/edit");
    }
    @PostMapping(value = "/update")
    public String updateCategory(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success","Edit Successful!");
        return "redirect:/category/";
    }
//    @GetMapping(value = "/view/{idIndex}")
//    public String showInformation(@PathVariable int idIndex,Model model){
//        Index index = indexService.findById(idIndex);
//        model.addAttribute("index",index);
//        return ("/index/view");
//    }
    @PostMapping(value = "/delete")
    public String deleteCategory(@RequestParam int idCategory, RedirectAttributes redirectAttributes){
        categoryService.remove(idCategory);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/category/";
    }
//    @PostMapping(value = "/search")
//    public String searchIndexByName(@RequestParam String name,Model model){
//        List<Category> categoryList =categoryService.findByName(name);
//        model.addAttribute("categoryList", categoryList);
//        return ("/category/display");
//    }
}
