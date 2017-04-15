package Springdemo;

import java.util.Random;

public class randomFortuneService implements FortuneService {
	
	String[] candidates = {"Get up early at 7", "Bouns point 5", "Bonus point 10"};
	Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(candidates.length);
		return candidates[index];
	}

}
