package com.example.workeachweek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("src/main/resources/mapper")
@SpringBootApplication
public class WorkEachWeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkEachWeekApplication.class, args);
    }

}
