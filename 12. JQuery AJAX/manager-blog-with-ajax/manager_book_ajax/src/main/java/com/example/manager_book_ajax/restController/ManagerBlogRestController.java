package com.example.manager_book_ajax.restController;

import java.util.List;

import com.example.manager_book_ajax.model.Blog;
import com.example.manager_book_ajax.service.BlogService;
import com.example.manager_book_ajax.service.CategoryService;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog")
public class ManagerBlogRestController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<Blog> getBlogs(@RequestParam("exits") int id) {
        List<Blog> blogs = blogService.findAllBlogs();
        return blogs;
    }
}
