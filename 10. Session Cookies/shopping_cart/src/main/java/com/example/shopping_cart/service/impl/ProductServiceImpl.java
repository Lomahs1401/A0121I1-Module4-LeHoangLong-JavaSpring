package com.example.shopping_cart.service.impl;

import java.util.List;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.ProductRepository;
import com.example.shopping_cart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateNameProduct(String newName, int id) {
        productRepository.changeNameProduct(newName, id);
    }

    @Override
    public void updatePriceProduct(double newPrice, int id) {
        productRepository.changePriceProduct(newPrice, id);
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void removeProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean isAvailable(Product product) {
        return productRepository.existsById(product.getProductId());
    }    

    @Override
    public boolean isAvailable(int id) {
        return productRepository.existsById(id);
    }
}
