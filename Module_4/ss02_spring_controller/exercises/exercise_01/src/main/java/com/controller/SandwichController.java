package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String goMenu(){
        return "menu";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam String[] condiment) {

        model.addAttribute("result",condiment);
        return "result";
    }

}
