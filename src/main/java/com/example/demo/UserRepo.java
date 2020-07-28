package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.*;
@Repository

public class UserRepo {

    @Autowired

    public JdbcTemplate jdbcTemplate;
	public User findById(String id) {

	    return jdbcTemplate.queryForObject("select * from student where username like ?", new Object[] {

	            id

	        },

	        new BeanPropertyRowMapper < User > (User.class));

	}
    }