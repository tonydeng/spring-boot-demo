package com.github.demo.boot;

import com.duoqu.demo.boot.SampleApplication;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

/**
 * Created by tonydeng on 15/5/5.
 */
public class SampleApplicationTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    @Test
    public void testCommandLineOverrides(){
        SampleApplication.main(new String[]{"--name=Tony"});
        String output=  outputCapture.toString();
        System.out.println(output);
    }
}
