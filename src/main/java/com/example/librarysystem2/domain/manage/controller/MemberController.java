package com.example.librarysystem2.domain.manage.controller;

import com.example.librarysystem2.domain.manage.entity.Member;
import com.example.librarysystem2.domain.manage.entity.dto.signInDto;
import com.example.librarysystem2.domain.manage.entity.dto.signUpDto;
import com.example.librarysystem2.domain.manage.entity.dto.userUpdateDto;
import com.example.librarysystem2.domain.manage.service.signInService;
import com.example.librarysystem2.domain.manage.service.signUpService;
import com.example.librarysystem2.domain.manage.service.userDeleteService;
import com.example.librarysystem2.domain.manage.service.userUpdateService;
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

    //메인 페이지
    @GetMapping("/")
    public String Main(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(sessionm==null){
        }
        else {
            session.setAttribute("member", sessionm);
        }
        return "realmain";
    }


    //로그인
    @GetMapping("/signin")
    public String signinpage(){
        return "signin";
    }
    //로그인 확인
    @PostMapping("/signIncheck")
    public String signIn(Model model, signInDto signInDto, HttpServletRequest request){
        Member member=signInService.signIn(signInDto);

        //db에 email이 없을때
        if(member==null){

            model.addAttribute("SIGNIN_OK","failid");
        }
        //db에 email이 있을때
        else {
             //db에 값이랑 email,password 같을때
            if (signInDto.getEmail().equals(member.getEmail()) && signInDto.getPassword().equals(member.getPassword())) {
                model.addAttribute("SIGNIN_OK", "success");
                sessionm = member;

            }
            //db에 값이랑 email은 같고 password가 다를때
            else if (signInDto.getEmail().equals(member.getEmail()) && !signInDto.getPassword().equals(member.getPassword())) {
                System.out.println("2");
                model.addAttribute("SIGNIN_OK", "failpwd");
            }
        }

        return "signIncheck";

    }

    //회원가입
    @GetMapping("/signup")
    public String signUppage(){
        return "signup";
    }

    //회원가입 확인
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

    //회원 수정 확인
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


    //로그아웃
    @GetMapping("/signout")
    public String signout() {
        sessionm=null;
        return "signout";
    }

    //회원 탈퇴
    @PostMapping("/userDelete")
    public String userDelete(HttpServletRequest request,Model model){
        userDeleteService.delete(sessionm.getEmail());
        model.addAttribute("DELETE_OK","success");
        sessionm=null;
        return "userDelete";
    }



}
