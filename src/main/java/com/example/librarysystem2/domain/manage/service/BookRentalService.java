package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRentalService {

    @Autowired
    private BookDao bookDao;

    //find book_state
    public String bookList1(String bookinfo){
        return bookDao.selectfindAll(bookinfo);
    }

    //find cnt
    public int bookList2(String bookinfo){return bookDao.selectfindcnt(bookinfo); }


    //update 정보
    public void bookrent(String book_name,String user_id,int cnt){
         bookDao.update(book_name,user_id,cnt);
    }
}
