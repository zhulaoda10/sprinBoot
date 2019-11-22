package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
//开启服务保护
@EnableHystrix
public class SpringCloudUserConsumerApplication {
    
//	//当添加@LoadBalanced注解，就代表启动Ribbon,进行负载均衡
	//@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserConsumerApplication.class, args);
    }

}
