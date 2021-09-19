package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {

    @GetMapping("/calculate")
    public String showCalculateForm(){
        return "calculator";
    }

    @GetMapping("/calculator")
    public String calculate(double firstOperand, double secondOperand, String operator, Model model){
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        switch (operator){
            case "addition":
                model.addAttribute("result",firstOperand + secondOperand);
                break;
            case "subtraction":
                model.addAttribute("result",firstOperand - secondOperand);
                break;
            case "multiplication":
                model.addAttribute("result",firstOperand * secondOperand);
                break;
            case "division":
                if (secondOperand != 0) {
                    model.addAttribute("result", firstOperand / secondOperand);
                } else {
                    model.addAttribute("error","Lỗi phép chia cho 0");
                }
                break;
        }
        return "calculator";
    }
}
