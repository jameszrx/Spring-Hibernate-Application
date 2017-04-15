package annotation.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {

	public static void main(String[] args) {
		//load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println(result);
		
		System.out.println("Memory Location theCoach: " + theCoach);
		
		System.out.println("Memory Location alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
