package com.example.manager_book_ajax.service;

import java.util.List;

import com.example.manager_book_ajax.model.Category;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryByIdCategory(int categoryId);
}
