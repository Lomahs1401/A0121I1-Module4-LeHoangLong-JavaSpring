package com.example.shopping_cart.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.shopping_cart.model.CartItem;
import com.example.shopping_cart.service.ShoppingCartService;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // giỏ hàng
    Map<Integer, CartItem> carts = new HashMap<>();

    @Override
    public Collection<CartItem> getAllItems() {
        return carts.values();
    }

    @Override
    public void addItem(CartItem item) {
        CartItem cartItem = carts.get(item.getProductId());
        if (cartItem == null) {
            carts.put(item.getProductId(), item);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }
    
    @Override
    public CartItem updateItem(Integer id, int quantity) {
        CartItem cartItem = carts.get(id);
        cartItem.setQuantity(quantity);
        return cartItem;
    }

    @Override
    public void removeItem(Integer id) {
        carts.remove(id);
    }

    @Override
    public void clear() {
        carts.clear();
    }

    @Override
    public int getCount() {
        return carts.values().size();
    }

    @Override
    public double total() {
        return carts.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }

}
