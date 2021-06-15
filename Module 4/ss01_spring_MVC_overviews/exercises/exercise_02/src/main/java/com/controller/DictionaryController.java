package com.controller;

import com.service.IDictionaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryServices dictionaryServices;
    @GetMapping(value = "/")
    public String goTranslate(){
        return "input";
    }
    @PostMapping(value = "/translate")
    public String translate(@RequestParam String txtSearch, Model model){
        String text=txtSearch;
        model.addAttribute("result",dictionaryServices.translate(text));
        return "result";
    }
}
