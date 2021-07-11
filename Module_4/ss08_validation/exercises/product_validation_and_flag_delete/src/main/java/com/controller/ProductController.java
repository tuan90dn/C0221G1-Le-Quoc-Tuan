package com.controller;


import com.dto.ProductDto;
import com.model.entity.Product;
import com.model.service.category_service.ICategoryService;
import com.model.service.product_service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("productDto",new ProductDto());
        model.addAttribute("category",this.categoryService.findAllCategory());
        return "/product/create";
    }
    @PostMapping(value = "/save")
    public String saveProduct(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "/product/create";
        }
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/product/";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEdit(Model model, @PathVariable int id){
        Product product = productService.findById(id);
        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("category",this.categoryService.findAllCategory());
        return "/product/edit";
    }
    @PostMapping(value = "/update")
    public String updateProduct(@Valid @ModelAttribute ProductDto productDto,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/product/edit";
        }
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
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
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes){
        productService.remove(id);
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
