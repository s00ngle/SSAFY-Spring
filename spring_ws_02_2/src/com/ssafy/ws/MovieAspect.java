package com.ssafy.ws;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class MovieAspect {

//    @Before("execution(* com.ssafy.ws.Audience.doSomething(..))")
	public void before() {
		System.out.println("영화관을 갑니다.");
	}

//    @AfterReturning("execution(* com.ssafy.ws.Audience.doSomething(..))")
	public void afterReturning() {
		System.out.println("영화가 끝나고 나옵니다.");
	}

//    @AfterThrowing("execution(* com.ssafy.ws.Audience.doSomething(..))")
	public void afterThrowing() {
		System.out.println("전화를 받습니다.");
	}

//  @After("execution(* com.ssafy.ws.Audience.doSomething(..))")
	public void after() {
		System.out.println("집에 갑니다.");
	}

}
