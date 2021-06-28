package com.asxb.bookstore.config;

import org.springframework.context.annotation.Configuration;
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
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/addBook").setViewName("addBook");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/shoppingCar").setViewName("shoppingCar");
        registry.addViewController("/console1").setViewName("console1");
        registry.addViewController("/editBook").setViewName("editBook");
        registry.addViewController("/listBook1").setViewName("listBook1");
        registry.addViewController("/listBook2").setViewName("listBook2");
        registry.addViewController("/listBook3").setViewName("listBook3");
        registry.addViewController("/listOrder1").setViewName("listOrder1");
        registry.addViewController("/listOrder2").setViewName("listOrder2");
        registry.addViewController("/listOrder3").setViewName("listOrder3");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login", "/register", "/static/**", "/mapping/**", "/loginAction", "/registerAction");
//    }
}
