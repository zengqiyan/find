package com.zqy.find.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(basePackages={"com.zqy"})
@EnableAutoConfiguration  
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
