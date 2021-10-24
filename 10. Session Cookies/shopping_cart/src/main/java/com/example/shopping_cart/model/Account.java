package com.example.shopping_cart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account")
public class Account implements Serializable{

    @Id
    @NotEmpty(message = "Tên tài khoản không được để trống")
    @Column(columnDefinition = "VARCHAR(30)")
    private String username;

    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Độ dài mật khẩu không nhỏ hơn 6 kí tự")
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String password;

    @NotEmpty(message = "Họ và tên không được để trống")  
    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullname;

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String email;

    private String photo;
    private Boolean activated;
    private Boolean admin;

    @JsonIgnore
    @OneToMany(targetEntity = Order.class, mappedBy = "account", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Account() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean isActivated() {
        return this.activated;
    }

    public Boolean getActivated() {
        return this.activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Boolean isAdmin() {
        return this.admin;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
