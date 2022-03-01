package com.example.gis.config;

import com.example.gis.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class GisWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/interorders/**");
    }
}