package com.controller;

import com.dao.CommonRepository;
import com.dto.response.GenericResponse;
import com.model.AppUser;
import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author avinash.a.mishra
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/User")
public class UserController {

   @Autowired
   private CommonRepository repository;

@GetMapping("/book/{userId}")
public List<Book> registerUser(@PathVariable Long userId) {
    AppUser user = repository.findById(AppUser.class, 1l);
     return user.getBorrowedBooks();
}

}
