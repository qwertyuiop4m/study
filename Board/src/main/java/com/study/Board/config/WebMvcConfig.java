package com.study.Board.config;

import com.study.Board.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
                .excludePathPatterns("/css/**","/images/**","/js/**");

        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/**/*.do")
                .excludePathPatterns("/log*");
    }
}
