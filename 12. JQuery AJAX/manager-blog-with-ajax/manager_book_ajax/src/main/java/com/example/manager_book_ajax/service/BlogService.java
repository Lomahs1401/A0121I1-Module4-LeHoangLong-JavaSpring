package com.example.manager_book_ajax.service;

import java.util.List;

import com.example.manager_book_ajax.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    List<Blog> findAllBlogs();
    Blog findBlogById(int id);
    Page<Blog> findBlogByAuthor(String name, Pageable pageable);
    Page<Blog> findAllBlogsPage(Pageable pageable);
    Page<Blog> findAllBlogsPageByCategoryId(Pageable pageable, int categoryId);
    void saveBlog(Blog blog);
    void removeBlog(Blog blog);
    void removeBlogById(int id);
}

