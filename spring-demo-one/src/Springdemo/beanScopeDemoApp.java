package Springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check it they are the same beans
		boolean result = (myCoach == alphaCoach);
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nAddress of myCoach: " + myCoach);
		System.out.println("\nAddress of alphaCoach: " + alphaCoach);
		context.close();
	}

}
