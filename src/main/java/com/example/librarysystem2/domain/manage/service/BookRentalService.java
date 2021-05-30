package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRentalService {

    @Autowired
    private BookDao bookDao;

    public String bookList1(String bookinfo){
        return bookDao.selectfindAll(bookinfo);
    }

    public void bookrent(String book_name,String user_id){
         bookDao.update(book_name,user_id);
    }
}
