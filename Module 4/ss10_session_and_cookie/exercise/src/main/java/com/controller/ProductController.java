package com.controller;

import com.model.entity.Cart;
import com.model.entity.Product;
import com.model.service.IProductService;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping(value = "/view/{id}")
    public String showInformation(@PathVariable int id, Model model){
        Product product=productService.findById((long) id);
        if (product==null) {
            return "/error.404";
        }
        model.addAttribute("product",product);
        return "/view";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional==null) {
            return "/error.404";
        }
        if (action.equals("add")) {
            cart.addProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        if (action.equals("sub")) {
            cart.subProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        if (action.equals("del")) {
            cart.delProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional);
        return "redirect:/shop";
    }

}
