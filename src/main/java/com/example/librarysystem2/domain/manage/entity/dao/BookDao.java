package com.example.librarysystem2.domain.manage.entity.dao;

import com.example.librarysystem2.domain.manage.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDao {

    private JdbcTemplate jdbcTemplate;
    public BookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Book> selectAll() {
        List<Book> results = jdbcTemplate.query("select * from BOOK",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("COUNT"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                });
        return results;
    }


    public String selectfindAll(String bookname) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where book_name=?" ,
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("COUNT"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                },bookname);
        return results.get(0).getBook_state();
    }


    public List<Book> selectByEmail(String bookinfo,String jogun) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where "+jogun+" like '%" + bookinfo +"%'",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("COUNT"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                });
        return results;
    }


    public void update (String book_name,String user_id){
        jdbcTemplate.update("update book set book_state=? ,user_id=? where book_name=?",
                "불가능",user_id,book_name);
    }


    public List<Book> selectByUserid(String userid) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where user_id=?",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("COUNT"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                },userid);
        return results;
    }

    public void update1 (String book_name){
        jdbcTemplate.update("update book set book_state=? ,user_id=? where book_name=?",
                "가능",null,book_name);
    }




}
