package com.example.librarysystem2.domain.member.entity.dao;

import com.example.librarysystem2.domain.member.entity.Member;
import com.example.librarysystem2.domain.member.entity.dto.signUpDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBERST",
                (ResultSet rs, int rowNum) -> {
                    Member member = new Member( rs.getString("EMAIL"), rs.getString("PASSWORD"),rs.getString("NAME"), rs.getString("PHONE"),rs.getTimestamp("REGDATE").toLocalDateTime());
                    member.setId(rs.getLong("ID"));
                    return member;
                });
        return results;
    }

    public void insert (signUpDto signUpDto){

        jdbcTemplate.update("insert memberst (email,password,name,phone,regdate) values (?,?,?,?,?)",
                signUpDto.getEmail(), signUpDto.getPassword(), signUpDto.getName(), signUpDto.getPhone(),signUpDto.getRegisterDateTime());
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query("select * from memberst where email=?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getString("phone"),
                                rs.getTimestamp("regdate").toLocalDateTime());
                        member.setId(rs.getLong("id"));
                        return member;
                    }
                }, email);
        return results.isEmpty() ? null : results.get(0);
    }



}
