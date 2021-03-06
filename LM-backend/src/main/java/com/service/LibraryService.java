package com.service;

import com.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibraryService {

    public void removeBookFromList(Long id, List<Book> bookListLibrary);

    public void saveNewBookToLibrary(Book book);

    public List<Book> getAllBooksFromLibrary();

    public void returnBookToLibrary(Long id);

    public void borrowBookFromLibrary(Long id);
}
