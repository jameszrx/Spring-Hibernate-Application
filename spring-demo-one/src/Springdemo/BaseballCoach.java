package Springdemo;

public class BaseballCoach implements Coach {
	//Define a private field for the dependency
	private FortuneService fortuneService;
	
	//Define a constructor for DI
	public BaseballCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout(){
		return "Get a 30-min batting practice.";
	}

	@Override
	public String getDailyFortune() {
		//use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
