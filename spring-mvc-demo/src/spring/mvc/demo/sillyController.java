package spring.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sillyController {
	
	@RequestMapping("/showForm")
	public String displayForm(){
		return "silly";
	}
}
