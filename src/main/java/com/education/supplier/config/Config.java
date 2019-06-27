package com.education.supplier.config;

import com.education.supplier.interceptor.AuthInterceptor;
import com.education.supplier.interceptor.IdentityParamResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 15:31
 * Email: fanyafeng@live.cn
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**/**", "/**/**/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new IdentityParamResolver());
    }
}
