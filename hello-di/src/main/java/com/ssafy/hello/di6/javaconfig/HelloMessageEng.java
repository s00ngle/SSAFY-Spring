package com.ssafy.hello.di6.javaconfig;

import org.springframework.stereotype.Component;

@Component("eng")
public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng() {
		System.out.println("HelloMessageEng Contructor Call!!!!!!!!!");
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}
	
}
