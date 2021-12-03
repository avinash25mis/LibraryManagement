package com.model;


import com.model.common.IEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Library implements IEntity {
    @Id
    @SequenceGenerator(name = "book_id", sequenceName = "seq_book_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id")
    private Long id;
    private String name;
    @OneToMany
    private List<Book> bookList;
}
