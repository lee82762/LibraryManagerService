package com.example.librarysystem2.domain.manage.service;

import com.example.librarysystem2.domain.manage.entity.Member;
import com.example.librarysystem2.domain.manage.entity.dao.MemberDao;
import com.example.librarysystem2.domain.manage.entity.dto.userUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;

public class userUpdateService {
    @Autowired
    private MemberDao memberDao;

    public void userupdate(userUpdateDto userUpdateDto){
        memberDao.update(userUpdateDto);
    }

    public Member sessionchange(userUpdateDto userUpdateDto){

        return memberDao.selectByEmail(userUpdateDto.getEmail());

    }

}
