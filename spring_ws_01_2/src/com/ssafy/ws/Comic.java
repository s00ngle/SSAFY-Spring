package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component("comic")
public class Comic implements Movie{

	@Override
	public String getInfo() {
		return "코믹영화를 관람합니다.";
	}
}
