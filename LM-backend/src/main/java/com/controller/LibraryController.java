package com.controller;


import com.model.Book;

import com.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Library")
@Transactional
public class LibraryController {



    @Autowired
    private LibraryService libraryService;

    @PostMapping("/book")
    public String save(@RequestBody Book book) {
        libraryService.saveNewBookToLibrary(book);
        return "saved";
    }



    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooksFromLibrary();

    }



    @PostMapping("/book/borrow/{id}")
    public String borrowBook(@PathVariable Long id) {
        libraryService.borrowBookFromLibrary(id);
        return "borrowed";
    }




    @PostMapping("/book/return/{id}")
    public String returnBook(@PathVariable Long id) {

        libraryService.returnBookToLibrary(id);
        return "borrowed";
    }



}


