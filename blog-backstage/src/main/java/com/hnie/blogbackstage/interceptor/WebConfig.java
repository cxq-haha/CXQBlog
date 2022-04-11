package com.hnie.blogbackstage.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:23
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/*")//拦截admin开头的所有访问路径
                .excludePathPatterns("/admin")//释放/admin的拦截
                .excludePathPatterns("/admin/login")//释放/admin/login的拦截
                ;
//                .excludePathPatterns("/admin/images/*");// todo ajax重定向拦截问题
        super.addInterceptors(registry);
    }
}
