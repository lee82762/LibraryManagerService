package com.example.librarysystem2.domain.manage.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private LocalDateTime registerDateTime;




    @Builder
    public Member(String email, String password, String name, String phone, LocalDateTime registerDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.registerDateTime=registerDateTime;
    }

}
