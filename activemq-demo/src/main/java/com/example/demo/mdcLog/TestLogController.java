package com.example.demo.mdcLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
	 Logger log = LoggerFactory.getLogger(getClass());

	    /**
	     * 测试登录
	     */
	    @RequestMapping(value = "/testLogin")
	    public String testLogin() {
	    	 // 级别由低到高 trace<debug<info<warn<error
            log.trace("这是一个trace日志...");
            log.debug("这是一个debug日志...");
            // SpringBoot默认是info级别，只会输出info及以上级别的日志
            log.info("这是一个info日志...");
            log.warn("这是一个warn日志...");
            log.error("这是一个error日志...");
            String str = "https://www.cnblogs.com/steveshao/";
            log.info("======欢迎访问无脚鸟的博客：{}\n", str);
	        log.info("用户登录成功！");
	        return "ok";
	    }

	    /**
	     * 测试下单
	     */
	    @RequestMapping(value = "/testNewOrder")
	    public String testNewOrder() {
	        log.info("用户创建了订单！");
	        log.info("请求完成，返回ok！");
	        return "ok";
	    }

	    /**
	     * 测试购买
	     */
	    @RequestMapping(value = "/testPay")
	    public String testPay() {
	        log.info("用户付款！");
	        return "ok";
	    }

}
