package com.example.librarysystem2.domain.manage.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Book {
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

    @Builder
    public Book(String book_name,String author, String publisher,String genre,String book_num, String book_state,String book_img, LocalDateTime bookregDateTime,String user_id,int cnt){
        this.book_name=book_name;
        this.author=author;
        this.publisher=publisher;
        this.genre=genre;
        this.book_num=book_num;
        this.book_state=book_state;
        this.book_img=book_img;
        this.bookregDateTime=bookregDateTime;
        this.user_id=user_id;
        this.cnt=cnt;
    }

}
