package com.example.shopping_cart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public int getCategoryId() {
        return this.id;
    }

    public void setCategoryId(int categoryId) {
        this.id = categoryId;
    }

    public String getCategoryName() {
        return this.name;
    }

    public void setCategoryName(String categoryName) {
        this.name = categoryName;
    }

    public List<Product> getCategoryProduct() {
        return this.products;
    }

    public void setCategoryProduct(List<Product> products) {
        this.products = products;
    }

}
