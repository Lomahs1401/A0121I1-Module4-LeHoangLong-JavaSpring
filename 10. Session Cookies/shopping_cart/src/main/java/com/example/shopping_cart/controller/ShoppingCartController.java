package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.CartItem;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.ProductService;
import com.example.shopping_cart.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCartService cartService;

    @GetMapping("/views")
    public String viewCarts(Model model) {
        model.addAttribute("carts", cartService.getAllItems());
        model.addAttribute("total", cartService.total());
        return "cart/item";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(product.getProductId());
            cartItem.setName(product.getProductName());
            cartItem.setPrice(product.getPrice());
            cartItem.setQuantity(1);
            cartService.addItem(cartItem);
        }
        return "redirect:/shopping-cart/views";
    }

    @GetMapping("/clear")
    public String clearCart() {
        cartService.clear();
        return "redirect:/shopping-cart/views"; 
    }

    @GetMapping("/delete/{id}")
    public String removeCart(@PathVariable("int") Integer id) {
        cartService.removeItem(id);
        return "redirect:/shopping-cart/views"; 
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id, @RequestParam("quantity") int quantity) {
        cartService.updateItem(id, quantity);
        return "redirect:/shopping-cart/views";
    }
}
