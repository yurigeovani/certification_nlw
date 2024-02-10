package com.ygtech.certification_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
    
    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://172.17.32.105:5432/pg_nlw");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Post1234");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);
    }

    public void run(String... args){
        executeSqlFile("src/main/resources/create.sql");
    }

    private void executeSqlFile(String filePath){
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            jdbcTemplate.execute(sqlScript);
            System.out.println("Seed done successfully");
        } catch (IOException e) {
            System.out.println("Error to run file: " + e.getMessage());
        }
    }

}
