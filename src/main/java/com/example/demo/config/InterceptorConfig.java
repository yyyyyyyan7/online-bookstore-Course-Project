package com.example.demo.config;

import com.example.demo.interceptor.AdminInterceptor;
import com.example.demo.interceptor.ClientLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ClientLoginInterceptor())
                .addPathPatterns("/order/submit");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/user/**").excludePathPatterns(new String[]{"/user/login","/user/register"})
                .addPathPatterns("/order/**").excludePathPatterns("/order/submit")
                .addPathPatterns("/book/**");
    }
}
