package com.dto;


import lombok.Data;

@Data
public class BookVO {
    private Long id;
    private String name;
    private String author;
    private Integer copies;
}
