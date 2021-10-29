package com.example.manager_book_ajax.service.impl;

import java.util.List;

import com.example.manager_book_ajax.model.Blog;
import com.example.manager_book_ajax.repository.BlogRepository;
import com.example.manager_book_ajax.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
    
    @Override
    public Page<Blog> findBlogByAuthor(String name, Pageable pageable) {
        return blogRepository.findAllBlogsByAuthorContaining(name, pageable);
    }  

    @Override
    public Page<Blog> findAllBlogsPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogsPageByCategoryId(Pageable pageable, int categoryId) {
        return blogRepository.findAllBlogsByCategoryId(pageable, categoryId);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void removeBlogById(int id) {
        blogRepository.deleteById(id);
    }
    
}
