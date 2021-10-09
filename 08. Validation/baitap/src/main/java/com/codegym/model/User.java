package com.codegym.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private int id;

    @NotEmpty(message = "Ten khong duoc de trong!")
    @Size(min = 2, max = 50, message = "Ten toi thieu 2 ki tu va toi da 50 ki tu")
    private String username;

    @NotNull(message = "Tuoi khong duoc de trong!")
    @Min(value = 18, message = "Tuoi phai du 18 tuoi tro len")
    private int age;
    
    private String address;


    public User() {
    }
    


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", age='" + getAge() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

}
