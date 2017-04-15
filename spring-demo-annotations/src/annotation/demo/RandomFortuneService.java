package annotation.demo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This message is from RandomFortuneService.";
	}

}
