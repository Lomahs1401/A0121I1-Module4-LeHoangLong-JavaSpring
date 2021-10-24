package com.example.shopping_cart.service;

import java.util.Collection;

import com.example.shopping_cart.model.CartItem;

public interface ShoppingCartService {
    public void addItem(CartItem item);
    public void removeItem(Integer id);
    public CartItem updateItem(Integer id, int quantity);
    public void clear();
    public Collection<CartItem> getAllItems();
    public int getCount();
    public double total();
}
