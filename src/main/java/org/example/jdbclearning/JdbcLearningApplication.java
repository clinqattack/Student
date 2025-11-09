package org.example.jdbclearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ServletComponentScan
public class JdbcLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcLearningApplication.class, args);
    }


}
