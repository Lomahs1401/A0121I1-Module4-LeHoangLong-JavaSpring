package com.example.baitap.repository;

import java.util.List;

import com.example.baitap.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    @Query(value = "SELECT * FROM category", nativeQuery = true)
    public List<Category> getAllCategory();
}
