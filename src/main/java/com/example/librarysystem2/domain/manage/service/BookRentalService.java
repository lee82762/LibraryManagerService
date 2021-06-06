package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRentalService {

    @Autowired
    private BookDao bookDao;

    //책상태 출력
    public String bookList1(String bookinfo){
        return bookDao.selectfindstate(bookinfo); }

    //조회수 출력
    public int bookList2(String bookinfo){
        return bookDao.selectfindcnt(bookinfo); }


    //update 정보
    public void bookrent(String book_name,String user_id,int cnt){
        bookDao.update(book_name,user_id,cnt);
    }
}
