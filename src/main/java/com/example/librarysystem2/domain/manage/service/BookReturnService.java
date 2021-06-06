package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Book;
import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookReturnService {
    @Autowired
    private BookDao bookDao;

    //나의 대여 현황
    public List<Book> mylist(String user_id){
        return bookDao.selectByUserid(user_id);
    }

    //도서 반납
    public void bookreturn(String book_name){
        bookDao.update1(book_name);

    }
}
