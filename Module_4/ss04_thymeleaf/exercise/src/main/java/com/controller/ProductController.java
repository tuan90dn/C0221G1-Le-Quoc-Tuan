package com.controller;

import com.model.bean.Product;
import com.model.service.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/products"})
public class ProductController {
    @Autowired
    private IProductServices productServices;
    @GetMapping(value = {"","/list"})
    public String index(Model model, RedirectAttributes redirectAttributes){
        List<Product> productList=productServices.findAllProduct();
        model.addAttribute("products",productList);
        redirectAttributes.addFlashAttribute("success","");
        return ("index");
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return ("create");
    }
    @PostMapping(value = "/products/save")
    public String saveProduct(Product product,RedirectAttributes redirectAttributes){
        productServices.saveProduct(product);
        redirectAttributes.addFlashAttribute("success","Create Successful!");
        return "redirect:/products/";
    }
    @GetMapping(value = "/edit/{idProduct}")
    public String showEdit(Model model, @PathVariable int idProduct){
        Product product = productServices.findProductById(idProduct);
        model.addAttribute("product",product);
        return ("edit");
    }
    @PostMapping(value = "/product/update")
    public String updateProduct(Product product,RedirectAttributes redirectAttributes){
        productServices.updateProduct(product.getIdOfProduct(),product);
        redirectAttributes.addFlashAttribute("success","Edit Successful!");
        return "redirect:/products/";
    }
    @GetMapping(value = "/view/{idProduct}")
    public String showInformation(@PathVariable int idProduct,Model model){
        Product product = productServices.findProductById(idProduct);
        model.addAttribute("product",product);
        return ("view");
    }
//
    @PostMapping(value = "/search")
    public String searchProductByName(@RequestParam String name,Model model){
        List<Product> productList=productServices.findProductByName(name);
        model.addAttribute("products",productList);
        return ("index");
    }
//    @GetMapping(value = "/delete/{idProduct}")
//    public String showDelete(Model model,@PathVariable int idProduct){
//        Product product = productServices.findProductById(idProduct);
//        model.addAttribute("product",product);
//        return ("redirect:/products/");
//    }
    @PostMapping(value = "/delete")
    public String deleteProduct(@RequestParam int idProduct,RedirectAttributes redirectAttributes){
        productServices.deleteProduct(idProduct);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/products/";
    }



}
