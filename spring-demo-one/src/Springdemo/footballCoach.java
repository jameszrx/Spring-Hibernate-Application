package Springdemo;

public class footballCoach implements Coach {
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Hey! How's it going!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
}
