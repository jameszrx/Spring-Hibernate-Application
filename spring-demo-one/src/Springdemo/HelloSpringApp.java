package Springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrive bean from container
		Coach thecoach = context.getBean("myCoach", Coach.class);
		
		//call method on the bean
		System.out.println(thecoach.getDailyWorkout());
		
		//Create the fortune service method
		System.out.println(thecoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
