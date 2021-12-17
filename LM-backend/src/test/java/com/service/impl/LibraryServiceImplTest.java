package com.service.impl;


import com.dao.CommonRepository;
import com.model.Book;
import com.service.LibraryService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryServiceImplTest {


    @Mock
    private CommonRepository repository;

    @InjectMocks
    private LibraryService libraryService;


    private Book getBook(){
        Book book= new Book();
        book.setId(1l);
        book.setAuthor("Author");
        book.setName("book");
        return book;
    }


}
