package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class userDeleteService {

    @Autowired
    private MemberDao memberDao;

    //회원탈퇴
    public void  delete(String email){
        memberDao.delete(email);
    }
}
