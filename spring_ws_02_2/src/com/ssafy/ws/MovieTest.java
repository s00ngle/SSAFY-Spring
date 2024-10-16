package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Audience audience = context.getBean("audience", Audience.class);
        try {
            audience.doSomething();
        } catch (CallException e) {
        }
    }
}
