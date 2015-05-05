package com.github.demo.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tonydeng on 15/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
public class SpringTestSampleApplicationTest {
    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testContextLoads(){
        Assert.assertNotNull(this.ctx);
        Assert.assertTrue(ctx.containsBean("helloService"));
        Assert.assertTrue(ctx.containsBean("sampleApplication"));
    }
}
