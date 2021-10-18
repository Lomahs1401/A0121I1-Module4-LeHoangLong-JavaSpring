package com.example.baitap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Borrow {

    @Id
    private String codeOfBook;
    
    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Book book;


    public Borrow() {
    }


    public String getCodeOfBook() {
        return this.codeOfBook;
    }

    public void setCodeOfBook(String codeOfBook) {
        this.codeOfBook = codeOfBook;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
}
