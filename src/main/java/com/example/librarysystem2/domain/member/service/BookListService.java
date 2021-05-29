package com.example.librarysystem2.domain.member.service;

import com.example.librarysystem2.domain.member.entity.Book;
import com.example.librarysystem2.domain.member.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookListService {

    @Autowired
    private BookDao bookDao;

    public List<Book> bookList(){
        return bookDao.selectAll();
    }
}
