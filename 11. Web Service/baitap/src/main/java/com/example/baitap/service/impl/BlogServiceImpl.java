package com.example.baitap.service.impl;

import java.util.List;

import com.example.baitap.model.Blog;
import com.example.baitap.repository.BlogRepository;
import com.example.baitap.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> getListBlog() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getBlogsByCategory(int id) {
        return blogRepository.getBlogsByCategoryId(id);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(int id) {
       blogRepository.deleteById(id); 
    }
}
