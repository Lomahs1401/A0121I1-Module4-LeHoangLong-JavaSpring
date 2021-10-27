package com.example.baitap.service;

import com.example.baitap.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getListCategory();

    Category findCategoryById(int id);

    void saveCategory(Category category);

    void removeCategory(int id);
}