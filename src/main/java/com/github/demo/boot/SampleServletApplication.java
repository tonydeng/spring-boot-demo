package com.github.demo.boot;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by tonydeng on 15/5/5.
 */
@Configurable
@EnableAutoConfiguration
public class SampleServletApplication extends SpringBootServletInitializer {
    @SuppressWarnings("serial")
    @Bean
    public Servlet dispatcherServlet(){
        return new GenericServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
                res.setContentType("text/plain");
                res.getWriter().append("Hello World");
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SampleServletApplication.class);
    }
}
