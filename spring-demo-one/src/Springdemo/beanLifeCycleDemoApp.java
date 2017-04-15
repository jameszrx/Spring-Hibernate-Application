package Springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanLifeCycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		System.out.println(myCoach.getDailyWorkout());
		context.close();
	}

}
