package Springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach(){
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it" + fortuneService.getFortune();
	}
	
	//add an init method
	public void customStartupStuff(){
		System.out.println("TrackCoach: Running custom startup method.");
	}
	//add a destroy method
	public void customDestroyStuff(){
		System.out.println("TrackCoach: Running custom destroy method.");
	}
	
}
