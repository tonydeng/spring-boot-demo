package com.github.demo.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by tonydeng on 15/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleServletApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class SampleServletApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(SampleServletApplicationTest.class);
    @Value("${local.server.port}")
    private int port;
    @Autowired
    private SecurityProperties security;

    @Test
    public void testHomeIsSecure(){
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:"+port, String.class
        );

        Assert.assertEquals(HttpStatus.UNAUTHORIZED, entity.getStatusCode());
        log.info("status code:'{}'", entity.getStatusCode());
        log.info("header:'{}'",entity.getHeaders());
        log.info("body:'{}'",entity.getBody());
    }

    @Test
    public void testHome(){
        ResponseEntity<String> entity = new TestRestTemplate("user",getPassword()).getForEntity(
          "http://localhost:"+port,String.class
        );
        Assert.assertEquals(HttpStatus.OK,entity.getStatusCode());
        log.info("status code:'{}'", entity.getStatusCode());
        log.info("header:'{}'",entity.getHeaders());
        Assert.assertEquals("Hello World",entity.getBody());
        log.info("body:'{}'",entity.getBody());
    }

    private String getPassword(){
        return security.getUser().getPassword();
    }
}
