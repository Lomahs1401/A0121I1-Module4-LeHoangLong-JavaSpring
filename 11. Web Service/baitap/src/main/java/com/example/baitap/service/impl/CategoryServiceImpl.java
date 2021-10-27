package com.example.baitap.service.impl;

import java.util.List;

import com.example.baitap.model.Category;
import com.example.baitap.repository.CategoryRepository;
import com.example.baitap.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(int id) {
        categoryRepository.deleteById(id);
    }
    
    
}
