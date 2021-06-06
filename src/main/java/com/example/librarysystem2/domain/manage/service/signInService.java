package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Member;
import com.example.librarysystem2.domain.manage.entity.dao.MemberDao;
import com.example.librarysystem2.domain.manage.entity.dto.signInDto;
import org.springframework.beans.factory.annotation.Autowired;

public class signInService {
    @Autowired
    private MemberDao memberDao;

    //회원가입
    public Member signIn(signInDto signInDto) {
        String email=signInDto.getEmail();
        System.out.println("signIn="+email);
        Member member=memberDao.selectByEmail(email);
        return member;
    }

}
