package com.github.demo.boot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.OutputCapture;

/**
 * Created by tonydeng on 15/5/5.
 */
public class SampleApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(SampleApplicationTest.class);
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

//    @Test
    public void testCommandLineOverrides(){
        SampleApplication.main(new String[]{"--name=Tony"});
        String output=  outputCapture.toString();
        log.info("--------------SampleApplication test commandline output:'{}'", output);
    }
    @Test
    public void testDefaultSettings(){
        SampleApplication.main(new String[0]);
        String output = outputCapture.toString();
        log.info("--------------SampleApplication test default setting output:'{}'", output);
    }
}
