package com.annotation.myspringapp;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getMyFortuneService() {

		return "today is your lucky day";
	}

}
