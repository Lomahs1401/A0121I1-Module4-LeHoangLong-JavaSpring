package com.example.baitap.controller;


import com.example.baitap.model.Blog;
import com.example.baitap.model.Category;
import com.example.baitap.repository.BlogRepository;
import com.example.baitap.service.BlogService;
import com.example.baitap.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    
    @Autowired
    private BlogService blogService;

    @Autowired CategoryService categoryService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> listBlog() {

        List<Blog> blogs = blogService.getListBlog();

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {

        Blog blog = blogService.findBlogById(id);

        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listCategories(){
        List<Category> categoryList = categoryService.getListCategory();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Category> showCategory(@PathVariable("id") int id){
        Category category =  categoryService.findCategoryById(id);
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        categoryService.removeCategory(id);
        return new ResponseEntity<>("Delete category successful", HttpStatus.OK);
    }

    @GetMapping("/category/blog")
    public ResponseEntity<HashMap<Category, List<Blog>>> getBlogOfCategory(){
        HashMap<Category, List<Blog>> blogs = new HashMap<>();
        for (Category category : categoryService.getListCategory()) {
            blogs.put(category, category.getBlogs());
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category/blog/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable("id") int id){
        Category category = categoryService.findCategoryById(id);
        if (category == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogs(), HttpStatus.OK);
    }

}