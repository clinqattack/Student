package org.example.jdbclearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@ServletComponentScan
public class JdbcLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcLearningApplication.class, args);
    }

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "649bc062d0");
    }

}
