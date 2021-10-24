package com.example.shopping_cart.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Products")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Boolean available;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_product_category"), nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(targetEntity = OrderDetails.class, mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

    public Product() {
    }

    public int getProductId() {
        return this.id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getProductName() {
        return this.name;
    }

    public void setProductName(String productName) {
        this.name = productName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isIsAvailable() {
        return this.available;
    }

    public boolean getIsAvailable() {
        return this.available;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }

    public Category getCategoryId() {
        return this.category;
    }

    public void setCategoryId(Category categoryId) {
        this.category = categoryId;
    }

}
