package com.example.manager_book_ajax.service.impl;

import java.util.List;

import com.example.manager_book_ajax.model.Category;
import com.example.manager_book_ajax.repository.CategoryRepository;
import com.example.manager_book_ajax.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryByIdCategory(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
    
}
