package Springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class randomFortuneApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach ftbCoach = context.getBean("myftbCoach",Coach.class);
		
		System.out.println(ftbCoach.getDailyWorkout());
		System.out.println(ftbCoach.getDailyFortune());
	}

}
