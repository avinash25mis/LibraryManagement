package com.controller;


import com.dao.CommonRepository;
import com.model.AppUser;
import com.model.Book;
import com.model.Library;
import com.service.LibraryService;
import org.apache.commons.collections.CollectionUtils;
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
    private CommonRepository repository;

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/book")
    public String save(@RequestBody Book book) {
        Library library = repository.findById(Library.class, 1l);
        List<Book> bookList = library.getBookList();
        Book savedBook = repository.saveOrUpdate(book);
        if (CollectionUtils.isEmpty(bookList)) {
            bookList.add(savedBook);
        } else {
            bookList.add(savedBook);
        }
        library.setBookList(bookList);
        repository.saveOrUpdate(library);
        return "saved";
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        Library library = repository.findById(Library.class, 1l);
        return library.getBookList();

    }

    @PostMapping("/book/borrow/{id}")
    public String borrowBook(@PathVariable Long id) {
        AppUser user = repository.findById(AppUser.class, 1l);
        Book savedBook = repository.findById(Book.class, id);
        List<Book> bookList = user.getBorrowedBooks();

        Library library = repository.findById(Library.class, 1l);
        List<Book> bookListLibrary = library.getBookList();
        libraryService.removeBookFromList(id, bookListLibrary);


        bookList.add(savedBook);

        user.setBorrowedBooks(bookList);
        repository.saveOrUpdate(user);

        return "borrowed";
    }


    @PostMapping("/book/return/{id}")
    public String returnBook(@PathVariable Long id) {

        Book savedBook = repository.findById(Book.class, id);
        AppUser user = repository.findById(AppUser.class, 1l);

        Library library = repository.findById(Library.class, 1l);
        List<Book> bookList = library.getBookList();
        List<Book> bookListLibrary = user.getBorrowedBooks();
        libraryService.removeBookFromList(id, bookListLibrary);

        bookList.add(savedBook);

        library.setBookList(bookList);
        repository.saveOrUpdate(user);

        return "borrowed";
    }

}


