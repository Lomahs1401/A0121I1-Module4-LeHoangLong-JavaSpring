package com.example.shopping_cart.repository;

import com.example.shopping_cart.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET name = :newName WHERE id = :id", nativeQuery = true)
    public void changeNameProduct(@Param("newName") String newName, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET prive = :newPrice WHERE id = :id", nativeQuery = true)
    public void changePriceProduct(@Param("newPrice") double newPrice, @Param("id") int id);
}