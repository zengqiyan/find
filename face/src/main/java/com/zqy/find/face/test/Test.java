package com.zqy.find.face.test;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zqy.exceptionHandle.exception.JsonRuntimeException;

@RestController
@EnableAutoConfiguration
public class Test {
	@RequestMapping("/")
    String home() throws JsonRuntimeException{
		throw new JsonRuntimeException("报错");
    }

    @RequestMapping("/now")
    String hehe() {
        return "现在时间：" + (new Date()).toLocaleString();
    }

}
