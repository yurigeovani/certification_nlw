package com.ygtech.certification_nlw.seed;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateSeed {
    
    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


}
