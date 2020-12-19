package com.wb.wbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WbsApplication.class, args);
    }
}
