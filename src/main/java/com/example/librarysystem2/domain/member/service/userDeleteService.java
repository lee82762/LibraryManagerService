package com.example.librarysystem2.domain.member.service;

import com.example.librarysystem2.domain.member.entity.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class userDeleteService {

    @Autowired
    private MemberDao memberDao;

    public void  delete(String email){
        memberDao.delete(email);
    }
}
