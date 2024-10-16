package com.ssafy.hello.di5.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
//		TODO :com/ssafy/hello/di5/xml/applicationContext.xml를 사용하여 ApplicationContext 생성
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di5/annotation/applicationContext.xml");
		System.out.println("context 읽기 끝!!!");
		
//		HelloMessage helloMessage = context.getBean(HelloMessage.class);
//		HelloMessage helloMessage = (HelloMessage) context.getBean("kor");
		HelloMessage helloMessage = context.getBean("kor", HelloMessage.class);

		String greeting = helloMessage.hello("안효인");
//		String greeting = helloMessage.hello("Mr. An");
		
		System.out.println(greeting);
		
		System.out.println("----------------------------------------");
		
//		HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
//		HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
//		System.out.println(kor1 + " ::::: " + kor2);
		
	}
	
}
