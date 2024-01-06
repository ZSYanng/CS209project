package com.example.cs209project;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan(basePackages = "com.example.cs209project.Mapper")
public class Cs209ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cs209ProjectApplication.class, args);
    }

}
