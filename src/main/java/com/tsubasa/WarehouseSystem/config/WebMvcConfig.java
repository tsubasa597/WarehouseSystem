package com.tsubasa.WarehouseSystem.config;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
            .addPathPatterns("/main/**")
            .excludePathPatterns("login")
            .excludePathPatterns("css/**")
            .excludePathPatterns("/fonts/**")
            .excludePathPatterns("/**.js");
    }
}