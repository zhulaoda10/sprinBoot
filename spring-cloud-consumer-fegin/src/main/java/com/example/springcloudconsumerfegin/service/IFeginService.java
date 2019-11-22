package com.example.springcloudconsumerfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//表示"user-service"的服务 提供
@FeignClient(value = "user-service")
public interface IFeginService {
 
    @RequestMapping(value = "/provider/getUser")
    //注意此处的方法名可以和服务提供者的不一致，因为是通过@FeignClient中的属性值和@RequestMapping
    //中的映射值决定的
    public String getUsers(@RequestParam("id") Integer id);
}