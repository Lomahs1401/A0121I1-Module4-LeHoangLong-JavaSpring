package com.example.baitap.repository;

import com.example.baitap.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
