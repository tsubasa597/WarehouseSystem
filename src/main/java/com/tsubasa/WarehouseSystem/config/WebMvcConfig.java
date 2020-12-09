package com.tsubasa.WarehouseSystem.config;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.interceptor.ApiInterceptor;
import com.tsubasa.WarehouseSystem.interceptor.LoginInterceptor;
import com.tsubasa.WarehouseSystem.interceptor.ManagerApiInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource 
    private LoginInterceptor loginInterceptor;
    @Resource 
    private ApiInterceptor apiInterceptor;
    @Resource
    private ManagerApiInterceptor managerApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/login")
            .excludePathPatterns("/css/**")
            .excludePathPatterns("/fonts/**")
            .excludePathPatterns("/**.js");
        registry.addInterceptor(apiInterceptor)
            .addPathPatterns("/api/");
        registry.addInterceptor(managerApiInterceptor)
            .addPathPatterns("/api/users/**")
            .addPathPatterns("/api/customer/**")
            .addPathPatterns("/api/supplier/**");
    }
}