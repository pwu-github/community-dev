package com.wp.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wp.community.mapper")
public class CommunityDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityDevApplication.class, args);
    }

}
