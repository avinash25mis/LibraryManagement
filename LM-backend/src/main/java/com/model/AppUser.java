package com.model;

import com.model.common.IEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

/**
 * @author avinash.a.mishra
 */
@Entity
@Data
@Table(name="app_user")
public class AppUser implements IEntity {

    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "seq_user_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String gender;
    @OneToMany
    private List<Book> borrowedBooks;


}
