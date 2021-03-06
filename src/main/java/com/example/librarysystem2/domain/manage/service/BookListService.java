package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Book;
import com.example.librarysystem2.domain.manage.entity.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookListService {

    @Autowired
    private BookDao bookDao;

    //전체 리스트 출력
    public List<Book> bookList(){
        return bookDao.selectAll();
    }

    //조건별 리스트 출력
    public List<Book> bookList2(String bookinfo, String jogun)
    {
        return bookDao.selectByEmail(bookinfo,jogun);
    }

    //장르별 리스트 출력
    public List<Book> bookList3(String genre)
    {
        return bookDao.selectBygenre(genre);
    }

    //랭킹 top5 출력
    public List<Book> rankingList(String condition){
        return bookDao.selectByCount(condition);
    }

}
