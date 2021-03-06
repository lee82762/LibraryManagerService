package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Book;
import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookReserService {
    @Autowired
    private BookDao bookDao;

    //예약자 유무 확인
    public String bookresercheck(String bookinfo){
        return bookDao.selectfindreser(bookinfo);
    }

    public int bookresercnt(String bookinfo){
        return bookDao.selectfindcnt(bookinfo);
    }

    //예약자 수정
    public void bookreser(String book_name,String user_id,int cnt){
        bookDao.updatereser(book_name,user_id,cnt);
    }

    //예약자 반환
    public void bookreserreturn(String book_name){
        bookDao.reserreturn(book_name);
    }

    //예약 현황
    public List<Book> myreserlist(String rental)
    {
        return bookDao.selectByrental(rental);
    }
}
