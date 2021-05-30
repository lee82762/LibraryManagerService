package com.example.librarysystem2.config;

import com.example.librarysystem2.domain.member.entity.dao.BookDao;
import com.example.librarysystem2.domain.member.entity.dao.MemberDao;
import com.example.librarysystem2.domain.member.service.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javaConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/library?characterEncoding=utf8&serverTimezone=UTC");
        ds.setUsername("user5");
        ds.setPassword("user5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;
    }


    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public signUpService signUpService(){
        return new signUpService();
    }

    @Bean
    public signInService signInService(){
        return new signInService();
    }

    @Bean
    public userUpdateService userUpdateService(){ return new userUpdateService(); }

    @Bean
    public userDeleteService userDeletService(){
        return new userDeleteService();
    }


    @Bean
    public BookDao bookDao() {
        return new BookDao(dataSource());
    }

    @Bean
    public BookListService bookListService(){ return  new BookListService(); }

    @Bean
    public BookRentalService bookRentalService(){
        return new BookRentalService();
    }

    @Bean
    public BookReturnService bookReturnService() { return  new BookReturnService(); }
}
