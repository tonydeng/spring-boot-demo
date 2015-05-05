package com.duoqu.demo.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tonydeng on 15/5/5.
 */
@Component
public class HelloService {
    @Value("${name:World}")
    private String name;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }
}
