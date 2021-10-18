package com.example.baitap.exception;

public class InvalidCode extends Exception {

    @Override
    public String getMessage() {
        return "Invalid Code of Book. Try again!";
    }
    
}
