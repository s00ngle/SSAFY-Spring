package com.ssafy.hello.di3;

public class HelloMessageKor implements HelloMessage {

	public HelloMessageKor() {
		System.out.println("HelloMessageKor 생성자 호출!!!");
	}
	
	public String hello(String name) {
		return "안녕하세요 " + name;
	}
	
}
