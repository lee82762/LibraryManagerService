package com.example.librarysystem2.domain.manage.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookListDto {
    private Long book_id;
    private String book_name;
    private String author;
    private String publisher;
    private String genre;
    private String book_num;
    private String book_state;
    private String book_img;
    private LocalDateTime bookregDateTime;
    private String user_id;
    private int cnt;
}
