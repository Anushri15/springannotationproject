package com.annotation.myspringapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("Print me when the Object is initialized");
	}

	@Autowired
	public TennisCoach(@Qualifier("happyFortuneServiceImpl") FortuneService fortuneService) {
		System.out.println("Print me when the Object is initialized with params");

		this.fortuneService = fortuneService;
	}

	@PostConstruct
	public void doSomeCrazyStuffs() {

		System.out.println("Hey Print me before the class is construct");
	}

	@Override
	public String getDailyWorkOut() {
		return "Daily WOrkout";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getMyFortuneService();
	}

	@PreDestroy
	public void callMeBeforeTheBeanIsDestroyed() {
		System.out.println("Call me before the bean is destroyed  ");
	}

}
