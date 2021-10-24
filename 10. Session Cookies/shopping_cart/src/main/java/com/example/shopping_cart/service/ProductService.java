package com.example.shopping_cart.service;

import java.util.List;

import com.example.shopping_cart.model.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public void addProduct(Product product);
    public void updateNameProduct(String name, int id);
    public void updatePriceProduct(double price, int id);
    public void removeProduct(Product product);
    public void removeProductById(int id);
    public boolean isAvailable(Product product);
    public boolean isAvailable(int id);
}
