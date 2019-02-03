package com.mlafroce.magnetico.practice01;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
	@Autowired
	private ApplicationContext context;

    @Test
    public void contextLoads() throws Exception {
    	assertNotNull(context);
    	System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
    }

}