package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component("action")
public class Action implements Movie{

	@Override
	public String getInfo() {
		return "액션영화를 관람합니다.";
	}
}
