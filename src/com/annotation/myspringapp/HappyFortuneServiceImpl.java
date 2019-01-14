package com.annotation.myspringapp;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneServiceImpl implements FortuneService {

	private String randomArray[];  /* ={ "Today is Happy Day", 
			"Beaware there could be wolfs in sheep's clothing",
			"Deligence is the mother of success!!!" };*/

	private Random random = new Random();

	@Override    
	@PostConstruct
	public String getMyFortuneService() {
		randomArray = new String[2];
		randomArray[0]= "Today is Happy Day";
		randomArray[1]= "Beaware there could be wolfs in sheep's clothing";
		int index = random.nextInt(randomArray.length);
		return randomArray[index];
	}

}
/* Explore more about the PostConstruct Method Useage 
he root cause is this is a Spring Bean Lifecycle issue.

When Spring creates the beans it follows this general process

1. Construct an instance of class
2. Inject dependencies
3. Set properties etc (@Value)

In your case, when you initialized the array using this code

    // create an array of strings
    private String[] data = { a, b, c, d, e };

The Spring Bean lifecycle was at step #1 above. It created an instance ... but during the assigment of the string array, the properties/fields for a, b, c, d, e haven't been set yet using @Value. That doesn't happen later until step #3.  So that's why you had null with the field assignment.

When you made mods to your code and moved the assignment into the getFortune() method, then by the time this method is invoked all steps 1-3 are already complete and it works as desired.

---

For this use case, the recommended solution is to use the @PostConstruct annotation. This is called at the end of the bean lifecycle process. So all of steps 1-3 are already completed and then you can safely perform assignments. This is the best use case for making any custom assignments in your code.

https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/9120288?start=0*/