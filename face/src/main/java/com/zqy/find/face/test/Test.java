package com.zqy.find.face.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zqy.exceptionHandle.exception.JsonRuntimeException;

@Controller
@EnableAutoConfiguration
public class Test {
	@RequestMapping("/")
    String home() throws JsonRuntimeException{
		throw new JsonRuntimeException("报错");
    }

    @RequestMapping("/now")
    String hehe() {
        return "index";
    }

}
