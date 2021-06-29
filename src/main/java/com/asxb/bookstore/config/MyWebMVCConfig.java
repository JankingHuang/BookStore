package com.asxb.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/console1").setViewName("console1");
        registry.addViewController("/console2").setViewName("console2");
        registry.addViewController("/listMyOrder1").setViewName("listMyOrder1");
        registry.addViewController("/listMyOrder2").setViewName("listMyOrder2");
        registry.addViewController("/listMyOrder3").setViewName("listMyOrder3");
        registry.addViewController("/listOrder1").setViewName("listOrder1");
        registry.addViewController("/listOrder2").setViewName("listOrder2");
        registry.addViewController("/listOrder3").setViewName("listOrder3");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/register", "/static/**", "/mapping/**", "/loginAction", "/registerAction");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/console1", "/addBook", "/editBook", "/listBook1", "/listBook2", "/listBook3",
                        "/listOrder1", "/listOrder2", "/listOrder3");
    }
}
