package com.zqy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.zqy.dao.datasource.DynamicDataSourceRegister;


@ComponentScan(basePackages={"com.zqy"})
@EnableAspectJAutoProxy
@EnableAutoConfiguration  
@Import(DynamicDataSourceRegister.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
