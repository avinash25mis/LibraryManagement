package com.service.Impl;

import com.model.Book;
import com.service.LibraryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;
@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {


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
}

