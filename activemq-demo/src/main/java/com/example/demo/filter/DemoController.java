package com.example.demo.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DemoController {
	 /**
     * test
     */
    @ResponseBody
    @RequestMapping(value = "/test")
    public String test() {
    	log.info("我是过滤器中的打印出来的！");
        return "OK";
    }
    
    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello zhuyafei";
    }
}
