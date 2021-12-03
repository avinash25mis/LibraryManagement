package com.model;


import com.model.common.IEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book implements IEntity {
    @Id
    @SequenceGenerator(name = "book_id", sequenceName = "seq_book_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id")
    private Long id;

    private String name;
    private String author;

}
