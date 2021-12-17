package com.service.Impl;

import com.dao.CommonRepository;
import com.model.AppUser;
import com.model.Book;
import com.model.Library;
import com.service.LibraryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;
@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private CommonRepository repository;

    public void removeBookFromList(Long id, List<Book> bookListLibrary) {
        if(CollectionUtils.isNotEmpty(bookListLibrary)){
            Iterator<Book> iterator = bookListLibrary.iterator();
            while(iterator.hasNext()){
                if(iterator.next().getId().equals(id)){
                    iterator.remove();
                }
            }
        }
    }


    public void saveNewBookToLibrary(Book book) {
        Library library = repository.findById(Library.class, 1l);
        List<Book> bookList = library.getBookList();
        Book savedBook = repository.saveOrUpdate(book);
        bookList.add(savedBook);
        library.setBookList(bookList);
        repository.saveOrUpdate(library);
    }

    public List<Book> getAllBooksFromLibrary() {
        Library library = repository.findById(Library.class, 1l);
        return library.getBookList();
    }

    public void returnBookToLibrary(Long id) {
        Book savedBook = repository.findById(Book.class, id);
        AppUser user = repository.findById(AppUser.class, 1l);

        Library library = repository.findById(Library.class, 1l);
        List<Book> bookList = library.getBookList();
        List<Book> bookListLibrary = user.getBorrowedBooks();
        removeBookFromList(id, bookListLibrary);
        bookList.add(savedBook);
        library.setBookList(bookList);
        repository.saveOrUpdate(user);
    }


    public void borrowBookFromLibrary(Long id) {
        AppUser user = repository.findById(AppUser.class, 1l);
        Book savedBook = repository.findById(Book.class, id);

        List<Book> bookList = user.getBorrowedBooks();
        Library library = repository.findById(Library.class, 1l);
        List<Book> bookListLibrary = library.getBookList();
        removeBookFromList(id, bookListLibrary);
        bookList.add(savedBook);
        user.setBorrowedBooks(bookList);
        repository.saveOrUpdate(user);
    }


}

