package com.example.librarysystem2.domain.member.controller;

import com.example.librarysystem2.domain.member.entity.Member;
import com.example.librarysystem2.domain.member.entity.dto.signInDto;
import com.example.librarysystem2.domain.member.entity.dto.signUpDto;
import com.example.librarysystem2.domain.member.service.signInService;
import com.example.librarysystem2.domain.member.service.signUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

//Member 관리

@Controller
public class MemberController {
    @Autowired
    private  signUpService signUpService;

    @Autowired
    private signInService signInService;



    @GetMapping("/")
    public String Main(){
        return "main";
    }



    @GetMapping("/signin")
    public String signinpage(){
        return "signin";
    }

    @PostMapping("/signIncheck")
    public String signIn(Model model, signInDto signInDto){
        Member member=signInService.signIn(signInDto);


        if(signInDto.getEmail().equals(member.getEmail())&&signInDto.getPassword().equals(member.getPassword())){
            model.addAttribute("SIGNIN_OK","success");
        }
        else if(!signInDto.getEmail().equals(member.getEmail()) || !signInDto.getPassword().equals(member.getPassword())){
            model.addAttribute("SIGNIN_OK","fail");
        }
        return "signIncheck";

    }

    @GetMapping("/signup")
    public String signUppage(){
        return "signup";
    }


    @PostMapping("/signUpcheck")
    public String signUp(signUpDto signUpDto, Model model){
        LocalDateTime time= LocalDateTime.now();

       // System.out.println(signUpDto.getRegisterDateTime());
        signUpDto.setRegisterDateTime(time);
        //System.out.println(signUpDto.getRegisterDateTime());
        signUpService.signUp(signUpDto);

        model.addAttribute("SIGNUP_OK", "success");
        return "signUpcheck";
    }






}
