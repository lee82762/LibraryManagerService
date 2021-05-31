package com.example.librarysystem2.domain.manage.controller;

import com.example.librarysystem2.domain.manage.entity.Book;
import com.example.librarysystem2.domain.manage.entity.Member;
import com.example.librarysystem2.domain.manage.service.BookListService;
import com.example.librarysystem2.domain.manage.service.BookRentalService;
import com.example.librarysystem2.domain.manage.service.BookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookListService bookListService;

    @Autowired
    private BookRentalService bookRentalService;

    @Autowired
    private BookReturnService bookReturnService;


    //도서 검색
    @GetMapping("/booklistcheck")
    public String booklist1(Model model){
        List<Book> bookList=bookListService.bookList();
        String img=bookList.get(0).getBook_img();

        model.addAttribute("imgpath",img);
        model.addAttribute("booklist",bookListService.bookList());
        return "bookList";
    }

    //도서 대출
    @GetMapping("/bookrental")
    public String bookrental(Model model){
        List<Book> bookList=bookListService.bookList();
        model.addAttribute("booklist",bookListService.bookList());
        return "bookrental";
    }

    //도서 대출 확인
    @PostMapping("/bookrentalcheck")
    public String bookrentalcheck(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

        String bookname=request.getParameter("bookname");
        String state=bookRentalService.bookList1(bookname);
        int cnt=bookRentalService.bookList2(bookname);

        if(state.equals("가능")&&member!=null){
            if(member!=null) {
                String user_id = member.getName();
                bookRentalService.bookrent(bookname,user_id,cnt);
            }
            model.addAttribute("RENTAL_OK","success");
        }
        else if(member==null){
            model.addAttribute("RENTAL_OK","logincheck");
        }
        else if(state.equals("불가능")){
            model.addAttribute("RENTAL_OK","fail");
        }
        return "bookrentalcheck";
    }


    //도서 반납
    @GetMapping("/bookreturn")
    public String bookreturn(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

        if(member!=null) {
            String bookname = request.getParameter("bookname");
            model.addAttribute("mybook", bookReturnService.mylist(member.getName()));
        }

        /*if(bookname!=null) {
            bookReturnService.bookreturn(bookname);
            model.addAttribute("RETURN_OK","success");
        }*/
        return "bookreturn";
    }
    //도서 반납 확인
    @PostMapping("/bookreturncheck")
    public String bookreturncheck(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
            String bookname = request.getParameter("bookname");
            bookReturnService.bookreturn(bookname);
            model.addAttribute("RETURN_OK", "success");


        return "bookreturncheck";
    }

  /*  @PostMapping("/bookSearch")
    public String bookSearch(Model model){
        return "bookList";
    }*/

    //도서 상세 검색
    @PostMapping("/check")
    public String bookSearch1(Model model, HttpServletRequest request){
        String bookinfo = request.getParameter("info");
        String jogun=request.getParameter("item");
        List<Book> bookList=bookListService.bookList2(bookinfo,jogun);
        model.addAttribute("booklist2",bookList);
        model.addAttribute("CHECK_OK","success");
        return "booksearchcheck";
    }
}
