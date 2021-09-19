package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class ConvertCurrency {
    @PostMapping
    public String convert(@RequestParam(value = "rate") String requestRate, @RequestParam(value = "usd") String requestUsd, Model model) {
        double rate = Double.parseDouble(requestRate);
        double usd = Double.parseDouble(requestUsd);
        double vnd = rate * usd;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
