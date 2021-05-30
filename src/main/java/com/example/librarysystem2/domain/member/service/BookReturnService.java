package com.example.librarysystem2.domain.member.service;

import com.example.librarysystem2.domain.member.entity.Book;
import com.example.librarysystem2.domain.member.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookReturnService {
    @Autowired
    private BookDao bookDao;

    public List<Book> mylist(String user_id){
        return bookDao.selectByUserid(user_id);
    }

    public void bookreturn(String book_name){
        bookDao.update1(book_name);

    }
}
