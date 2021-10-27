package com.example.baitap.service;

import java.util.List;

import com.example.baitap.model.Blog;

public interface BlogService {
    List<Blog> getListBlog();

    List<Blog> getBlogsByCategory(int id);

    Blog findBlogById(int id);

    void saveBlog(Blog blog);

    void removeBlog(int id);
}