package com.example.manager_book_ajax.repository;

import com.example.manager_book_ajax.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
    
    Page<Blog> findAllBlogsByAuthorContaining(String name, Pageable pageable);

    @Query(value = "SELECT * FROM blog INNER JOIN category WHERE blog.category_id = category.id AND category.id = :id", nativeQuery = true)
    Page<Blog> findAllBlogsByCategoryId(Pageable pageable, @Param("id") int categoryId);
}