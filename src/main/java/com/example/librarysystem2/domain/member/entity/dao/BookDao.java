package com.example.librarysystem2.domain.member.entity.dao;

import com.example.librarysystem2.domain.member.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class BookDao {

    private JdbcTemplate jdbcTemplate;
    public BookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Book> selectAll() {
        List<Book> results = jdbcTemplate.query("select * from BOOK",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),rs.getString("PUBLISHER"), rs.getString("GENRE"), rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(), rs.getString("USER_ID"), rs.getInt("COUNT"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                });
        return results;
    }




}
