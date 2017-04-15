package Springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 30 min.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//No-arg constructor
	public CricketCoach(){
		System.out.println("Cricket: No-arg constructor.");
	}
	//getter and setter
	public String getEmailAddress() {
		System.out.println("CricketCoach: emailAddress getter");
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: emailAddress setter");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		System.out.println("CricketCoach: team getter");
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: team setter");
		this.team = team;
	}

	//Setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
}
