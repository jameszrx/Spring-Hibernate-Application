package annotation.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach(){
		System.out.println("No-arg constructor.");
	}
	
	//Define init method
	@PostConstruct
	public void doMyStartupStuff(){
		System.out.println("Init method");
	}
	
	//Define destroy method
	@PreDestroy
	public void doMyDestroyStuff(){
		System.out.println("Cleanup methon");
	}
	
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice with Rafel Nadal.";
	}
	
	public String getDailyFortune(){
		return fortuneService.getFortune();
	}
	
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService){
		System.out.println("Inside setter");
		fortuneService = theFortuneService;
	}*/

}
