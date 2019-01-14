/**
 * 
 */
package com.annotation.myspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author anushrinayak
 *
 */
@Component
public class VolleyCoach implements Coach {

	/*
	 * (non-Javadoc)
	 * 
	 * practicing setting injections
	 */
	@Value("${mycoach.email}")
	private String emailAddress;
	@Value("${mycoach.team}")
	private String team;

	@Autowired
	@Qualifier("happyFortuneServiceImpl")
	private FortuneService fortuneService;

	/*
	 * @Autowired public void doSOmethingCrazy(@Qualifier("happyFortuneServiceImpl")
	 * FortuneService theFortuneService) {
	 * 
	 * fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkOut() {
		return "Do daily volley ball practise  " + emailAddress + team;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.annotation.myspringapp.Coach#getDailyFortune()
	 */
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getMyFortuneService();
	}

}
