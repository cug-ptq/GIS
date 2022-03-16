package com.example.gis.config;

import com.example.gis.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class GisWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器并设置拦截的请求路径
        InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**");
        registration.excludePathPatterns("/login","/login/auth","/login/signUp",
                "/**/*.html",
                "/**/js/*.js",
                "/**/js/jsService/*.js",
                "/**/css/*.css",
                "/**/img/*.png",
                "/**/img/*.jpg");
    }
}