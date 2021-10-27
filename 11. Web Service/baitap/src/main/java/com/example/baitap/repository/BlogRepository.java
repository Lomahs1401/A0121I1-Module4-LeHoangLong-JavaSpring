package com.example.baitap.repository;

import java.util.List;

import com.example.baitap.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> getBlogsByCategoryId(int categoryId);
}
