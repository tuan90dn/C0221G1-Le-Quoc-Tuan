package com.controller;


import com.model.entity.Product;
import com.model.service.category_service.ICategoryService;
import com.model.service.product_service.IProductService;
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
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "")
    public String display(Model model, @RequestParam Optional<String> name, @PageableDefault(size = 2)Pageable pageable){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Product> productPage = productService.findByName(keyword,pageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("success","");
        return "/product/display";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("category",this.categoryService.findAllCategory());
        return ("/product/create");
    }
    @PostMapping(value = "/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/product/";
    }
    @GetMapping(value = "/edit/{idProduct}")
    public String showEdit(Model model, @PathVariable int idProduct){
        Product product = productService.findById(idProduct);
        model.addAttribute("product", product);
        model.addAttribute("category",this.categoryService.findAllCategory());
        return ("/product/edit");
    }
    @PostMapping(value = "/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Edit Successful!");
        return "redirect:/product/";
    }
//    @GetMapping(value = "/view/{idIndex}")
//    public String showInformation(@PathVariable int idIndex,Model model){
//        Index index = indexService.findById(idIndex);
//        model.addAttribute("index",index);
//        return ("/index/view");
//    }
    @PostMapping(value = "/delete")
    public String deleteProduct(@RequestParam int idProduct, RedirectAttributes redirectAttributes){
        productService.remove(idProduct);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/product/";
    }
//    @PostMapping(value = "/search")
//    public String searchIndexByName(@RequestParam String name,Model model){
//        List<Category> categoryList =categoryService.findByName(name);
//        model.addAttribute("categoryList", categoryList);
//        return ("/category/display");
//    }
}
