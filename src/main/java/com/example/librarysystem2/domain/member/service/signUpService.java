package com.example.librarysystem2.domain.member.service;

import com.example.librarysystem2.domain.member.entity.dao.MemberDao;
import com.example.librarysystem2.domain.member.entity.dto.signUpDto;
import org.springframework.beans.factory.annotation.Autowired;


public class signUpService {

    @Autowired
    private MemberDao memberDao;

    public void signUp(signUpDto signUpDto) {

        String email = signUpDto.getEmail();
        System.out.println("insert:"+email);
        System.out.println("insert:"+signUpDto.getPassword());
        System.out.println("insert:"+signUpDto.getName());
        System.out.println("insert:"+signUpDto.getPhone());
        System.out.println("insert:"+signUpDto.getRegisterDateTime());
        memberDao.insert(signUpDto);
    }

}
