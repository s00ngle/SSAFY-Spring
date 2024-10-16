package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ComponentScan(basePackages = "com.ssafy.ws")
public class MovieTest {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(MovieTest.class);
        ApplicationContext context = new FileSystemXmlApplicationContext("resources/applicationContext.xml");
        
        Audience audience = context.getBean("audience", Audience.class);
        try {
            audience.doSomething();
        } catch (CallException e) {
        }
    }
}
