package com.example.librarysystem2.domain.manage.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class userUpdateDto {
    private String email;
    private String password;
    private String name;
    private String phone;
    private LocalDateTime registerDateTime;
}
