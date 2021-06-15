package com.controller;

import com.service.IConverterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
   @Autowired
   private IConverterServices converterServices;
   @GetMapping(value = {"/","/converter"})
   public String goConverter(){
      return "input";
   }
   @PostMapping(value = "/convert")
   public String convertCurrency(@RequestParam String rate, @RequestParam String usd, Model model){
      float a= Float.parseFloat(rate);
      float b= Float.parseFloat(usd);
      model.addAttribute("result",converterServices.convert(a,b));
      return "result";
   }
}
