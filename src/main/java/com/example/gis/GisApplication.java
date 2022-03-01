package com.example.gis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.gis.dao")
public class GisApplication {

    public static void main(String[] args) {
        SpringApplication.run(GisApplication.class, args);
    }

}
