package com.example.librarysystem2.domain.member.controller;

import com.example.librarysystem2.domain.member.entity.Book;
import com.example.librarysystem2.domain.member.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookListService bookListService;


    @GetMapping("/booklistcheck")
    public String booklist1(Model model){
        List<Book> bookList=bookListService.bookList();
        String img=bookList.get(0).getBook_img();

        model.addAttribute("imgpath",img);
        model.addAttribute("booklist",bookListService.bookList());
        return "bookList";
    }

    @PostMapping("/bookSearch")
    public String bookSearch(Model model){


        return "bookList";
    }

    @PostMapping("/check")
    public String bookSearch1(Model model, HttpServletRequest request){

        String lang = request.getParameter("lang");
        System.out.println(lang);
        model.addAttribute("CHECK_OK","success");
        return "booksearchcheck";
    }
}
