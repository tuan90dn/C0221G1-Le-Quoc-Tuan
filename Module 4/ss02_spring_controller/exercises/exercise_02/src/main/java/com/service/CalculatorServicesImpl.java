package com.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServicesImpl implements ICalculatorServices {
    @Override
    public double calculate(double firstOperand, double secondOperand, String operator) {
        switch (operator){
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
