//package com.example.demo.filter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
////@Component
//@WebFilter(filterName = "myFilter1", urlPatterns = "/test")
//public class MyFilter1 implements Filter{
//	@Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info(filterConfig.getFilterName() + " init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//        log.info("myFilter1 begin");
//        try {
//            log.info("业务方法执行");
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            log.error("error!", e);
//        }
//        log.info("myFilter1 end");
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
