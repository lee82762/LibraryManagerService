package com.example.librarysystem2.domain.member.controller;

import com.example.librarysystem2.domain.member.entity.Member;
import com.example.librarysystem2.domain.member.entity.dto.signInDto;
import com.example.librarysystem2.domain.member.entity.dto.signUpDto;
import com.example.librarysystem2.domain.member.entity.dto.userUpdateDto;
import com.example.librarysystem2.domain.member.service.signInService;
import com.example.librarysystem2.domain.member.service.signUpService;
import com.example.librarysystem2.domain.member.service.userDeleteService;
import com.example.librarysystem2.domain.member.service.userUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

//Member 관리 12

@Controller
public class MemberController {
    @Autowired
    private  signUpService signUpService;

    @Autowired
    private signInService signInService;

    @Autowired
    private userUpdateService userUpdateService;

    @Autowired
    private userDeleteService userDeleteService;

    static Member sessionm;

    @GetMapping("/")
    public String Main(HttpServletRequest request){
        HttpSession session=request.getSession();


        if(sessionm==null){

        }
        else {
            //sessionm.getEmail();
            session.setAttribute("member", sessionm);

        }
        return "main";
    }


    //로그인
    @GetMapping("/signin")
    public String signinpage(){
        return "signin";
    }

    @PostMapping("/signIncheck")
    public String signIn(Model model, signInDto signInDto, HttpServletRequest request){
        Member member=signInService.signIn(signInDto);



        if(signInDto.getEmail().equals(member.getEmail())&&signInDto.getPassword().equals(member.getPassword())){
            model.addAttribute("SIGNIN_OK","success");
            sessionm=member;

        }
        else if(!signInDto.getEmail().equals(member.getEmail()) || !signInDto.getPassword().equals(member.getPassword())){
            model.addAttribute("SIGNIN_OK","fail");
        }
        return "signIncheck";

    }

    //회원가입
    @GetMapping("/signup")
    public String signUppage(){
        return "signup";
    }


    @PostMapping("/signUpcheck")
    public String signUp(signUpDto signUpDto, Model model){
        if(signUpService.check(signUpDto)==false){
            model.addAttribute("SIGNUP_OK", "fail");
        }
        else {
            LocalDateTime time = LocalDateTime.now();
            signUpDto.setRegisterDateTime(time);
            signUpService.signUp(signUpDto);
            model.addAttribute("SIGNUP_OK", "success");
        }
        return "signUpcheck";
    }


    //회원 수정 페이지

    @GetMapping("/userUpdate")
    public String userUpdatepage(){
        return "userUpdate";
    }


    @PostMapping("/userUpdatecheck")
    public String userUpdate(userUpdateDto userUpdateDto, Model model){
        LocalDateTime time= LocalDateTime.now();
        userUpdateDto.setEmail(sessionm.getEmail());
        userUpdateDto.setRegisterDateTime(time);
        userUpdateService.userupdate(userUpdateDto);

        Member member=userUpdateService.sessionchange(userUpdateDto);

        sessionm=member;
        model.addAttribute("UPDATE_OK", "success");
        return "userUpdatecheck";
    }


    @PostMapping("/userDelete")
    public String userDelete(HttpServletRequest request,Model model){

        userDeleteService.delete(sessionm.getEmail());

        model.addAttribute("DELETE_OK","success");
        sessionm=null;


        return "userDelete";
    }



}
