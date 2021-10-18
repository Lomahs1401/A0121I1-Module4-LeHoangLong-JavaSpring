package com.example.baitap.exception;

public class InvalidQuantity extends Exception {
    
    @Override
    public String getMessage() {
        return "Quantity of book must be a value greater or equal than 1!";
    }
}
