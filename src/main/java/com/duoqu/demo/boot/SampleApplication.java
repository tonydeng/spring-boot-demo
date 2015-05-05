package com.duoqu.demo.boot;

import com.duoqu.demo.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tonydeng on 15/5/5.
 */
@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
    @Autowired
    private HelloService helloService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloService.getHelloMessage());
    }

    public static void main(String[] args){
        SpringApplication.run(SampleApplication.class,args);
    }
}
