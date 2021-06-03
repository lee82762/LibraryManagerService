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

    //전체 도서 출력
    public List<Book> selectAll() {
        List<Book> results = jdbcTemplate.query("select * from BOOK",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                });
        return results;
    }

    //해당도서 대여 가능 상태 출력
    public String selectfindstate(String bookname) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where book_name=?" ,
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                },bookname);
        return results.get(0).getBook_state();
    }


    //해당도서 예약 가능 상태 출력
    public String selectfindreser(String bookname) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where book_name=?" ,
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                },bookname);
        return results.get(0).getRental();
    }


    //해당 도서 조회수 출력
    public int selectfindcnt(String bookname) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where book_name=?" ,
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                            rs.getString("PUBLISHER"), rs.getString("GENRE"),
                            rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                            rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                            rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                    book.setBook_id(rs.getLong("BOOK_ID"));
                    return book;
                },bookname);
        return results.get(0).getCnt();
    }


    //검색 조건에 맞는 도서리스트
    public List<Book> selectByEmail(String bookinfo,String jogun) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where "+jogun+" like '%" + bookinfo +"%'",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                });
        return results;
    }

    //장르 조건에 맞는 도서리스트
    public List<Book> selectBygenre(String genre) {
        List<Book> results = jdbcTemplate.query("select * from book where genre=?",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                },genre);
        return results;
    }


    //도서 대출
    public void update (String book_name,String user_id,int cnt){
        jdbcTemplate.update("update book set book_state=? ,user_id=? ,cnt=? where book_name=?",
                "불가능",user_id,cnt+1,book_name);
    }

    //도서 예약
    public void updatereser (String book_name,String user_id,int cnt){
        jdbcTemplate.update("update book set rental=? ,cnt=? where book_name=?",
                user_id,cnt+1,book_name);
    }



    //로그인한 사용자 도서 대여 목록
    public List<Book> selectByUserid(String userid) {
        List<Book> results = jdbcTemplate.query("select * from BOOK where user_id=?",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                },userid);
        return results;
    }


    //도서 반납
   public void update1 (String book_name){
        jdbcTemplate.update("update book set book_state=? ,user_id=? where book_name=?", "가능",null,book_name);
    }

    //도서 예약 수정
    public void reserreturn (String book_name){
        jdbcTemplate.update("update book set rental=? where book_name=?", null,book_name);
    }


    public List<Book> selectByCount(String condition) {
        System.out.println("***"+condition);
        List<Book> results = jdbcTemplate.query("select * from BOOK where GENRE like"+"'%"+condition+"%'"+"ORDER BY CNT DESC LIMIT 5",
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book( rs.getString("BOOK_NAME"), rs.getString("AUTHOR"),
                                rs.getString("PUBLISHER"), rs.getString("GENRE"),
                                rs.getString("BOOK_NUM"), rs.getString("BOOK_STATE"),
                                rs.getString("BOOK_IMG"),rs.getTimestamp("BOOKREGDATE").toLocalDateTime(),
                                rs.getString("USER_ID"), rs.getInt("CNT"),rs.getString("RENTAL"));
                        book.setBook_id(rs.getLong("BOOK_ID"));
                        return book;
                    }
                });
        return results;
    }



}
