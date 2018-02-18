package com.ag04.Feeddit.configuration;

import com.ag04.Feeddit.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    public @Override void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor());
    }
}
