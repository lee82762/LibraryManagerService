package com.example.librarysystem2.domain.member.service;

import com.example.librarysystem2.domain.member.entity.Member;
import com.example.librarysystem2.domain.member.entity.dao.MemberDao;
import com.example.librarysystem2.domain.member.entity.dto.signInDto;
import org.springframework.beans.factory.annotation.Autowired;

public class signInService {
    @Autowired
    private MemberDao memberDao;

    public Member signIn(signInDto signInDto) {
        String email=signInDto.getEmail();
        System.out.println("signIn="+email);
        Member member=memberDao.selectByEmail(email);
        return member;
    }

}
