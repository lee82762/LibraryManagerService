package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Member;
import com.example.librarysystem2.domain.manage.entity.dao.MemberDao;
import com.example.librarysystem2.domain.manage.entity.dto.signUpDto;
import org.springframework.beans.factory.annotation.Autowired;


public class signUpService {

    @Autowired
    private MemberDao memberDao;

    public boolean check(signUpDto signUpDto){
        boolean already=false;
        Member member=memberDao.selectByEmail(signUpDto.getEmail());
        if(member==null){
            already=true;
        }
        return already;
    }

    public void signUp(signUpDto signUpDto) {

        String email = signUpDto.getEmail();
        memberDao.insert(signUpDto);
    }

}
