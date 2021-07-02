package com.controller;


import com.service.ICalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorServices calculatorServices;
    @GetMapping("/")
    public String goCalculate(){
        return "input";
    }
    @PostMapping(value = "/calculate")
    public String calculated(@RequestParam String first_operand,@RequestParam String second_operand,@RequestParam String operator,Model model){
        double firstOperand=Double.parseDouble(first_operand);
        double secondOperand=Double.parseDouble(second_operand);
//        String operator1=operator;
        double result=calculatorServices.calculate(firstOperand,secondOperand,operator);
        model.addAttribute("calculate",result);
        return "result";
    }
}
