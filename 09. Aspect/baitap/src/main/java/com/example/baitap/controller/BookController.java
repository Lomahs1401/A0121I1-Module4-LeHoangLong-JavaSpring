package com.example.baitap.controller;

import com.example.baitap.exception.InvalidCode;
import com.example.baitap.exception.InvalidQuantity;
import com.example.baitap.model.Book;
import com.example.baitap.model.Borrow;
import com.example.baitap.random.RandomString;
import com.example.baitap.repository.BookRepository;
import com.example.baitap.repository.BorrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    private static final int RANDOM_LENGTH = 5;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired 
    private BorrowRepository borrowRepository;

    @GetMapping("/list")
    public String getListBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("/listCode")
    public String getListCode(Model model) {
        model.addAttribute("borrows", borrowRepository.findAll());
        return "borrow/listCode";
    }

    @GetMapping("borrow/{id}")
    public String getIdBook(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("book", bookRepository.findById(id).get());
        String random = RandomString.randomAlphaNumeric(5);
        model.addAttribute("wordRandom", random);
        Borrow borrow = new Borrow();
        borrow.setCodeOfBook(random);
        borrow.setBook(bookRepository.findById(id).get());
        model.addAttribute("borrow", borrow);
        return "book/borrow";
    }

    @PostMapping(value="/borrow/{id}")
    public String getIdBorrow(@PathVariable(name = "id") int id, @ModelAttribute("borrow") Borrow borrow, Model model) throws InvalidQuantity {
        borrowRepository.save(borrow);
        Book book = bookRepository.findById(id).get();
        book.setQuantity(book.getQuantity() - 1);
        boolean check = (book.getQuantity() >= 0) ? true : false;
        if (!check) {
            throw new InvalidQuantity();
        }
        bookRepository.save(book);
        return "redirect:/list";
    }

    @GetMapping("return/{id}")
    public String returnIdBook(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "book/return";
    }

    @PostMapping("return/{id}")
    public String returnIdBookpost(@PathVariable(name = "id") int id, @RequestParam("code") String code, Model model) throws InvalidCode {
        Borrow borrow;
        try {
            borrow = borrowRepository.findById(code).get();
        } catch (Exception e) {
            throw new InvalidCode();
        }
        borrowRepository.delete(borrow);
        Book book = bookRepository.findById(id).get();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        return "redirect:/list";
    }
    
    @ExceptionHandler(InvalidCode.class)
    public String showInvalidCode() {
        return "error/invalidCode";
    }

    @ExceptionHandler(InvalidQuantity.class)
    public String showInvalidQuantity() {
        return "error/invalidQuantity";
    }
}
