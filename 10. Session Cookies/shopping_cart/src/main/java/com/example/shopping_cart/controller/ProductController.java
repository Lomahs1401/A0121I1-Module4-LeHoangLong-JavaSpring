package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.ProductService;
import com.example.shopping_cart.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/views")
    public String viewProducts(Model model) {
        if (checkLogout()) {
            model.addAttribute("lists", productService.getAllProducts());
            return "product/view-form";
        } else {
            return "redirect:/account/login";
        }
    }

    @GetMapping("/form")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping("/form")
    public String addProduct(@ModelAttribute("product") Product product) {
        
        return "";
    }

    public boolean checkLogout() {
        String username = sessionService.get("username");
        if (username != null) {
            return true;
        }
        return false;
    }
}
