package com.annotation.myspringapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationSpringApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationapplicationContext.xml");

		Coach coach = context.getBean("tennisCoach", Coach.class);

		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach.getDailyFortune());
		/*
		 * boolean result = (coach==coach1);
		 * System.out.println("Print the result ---"+result);
		 * System.out.println("Print coach object address "+coach);
		 * System.out.println("Print coach1 object address "+coach1);
		 */
		/*
		 * Coach volleyCoach = context.getBean("volleyCoach",Coach.class);
		 * System.out.println(volleyCoach.getDailyWorkOut());
		 * System.out.println(volleyCoach.getDailyFortune());
		 */

		context.close();
	}

}
