package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("resources/applicationContext.xml");

		// Action 영화 테스트
//		Movie actionMovie = context.getBean("action", Movie.class);
		Audience actionAudience = context.getBean("audience", Audience.class);
		actionAudience.watchMovie();
	}
}
