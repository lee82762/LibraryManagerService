package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Book;
import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookListService {

    @Autowired
    private BookDao bookDao;

    public List<Book> bookList(){
        return bookDao.selectAll();
    }


    public List<Book> bookList2(String bookinfo, String jogun){
        return bookDao.selectByEmail(bookinfo,jogun);
    }
}
