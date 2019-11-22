package com.example.demo.mdcLog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer{
	                                      
	 @Bean
	    public SessionInterceptor getSessionInterceptor() {
	        return new SessionInterceptor();
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/*");
	    }

}
