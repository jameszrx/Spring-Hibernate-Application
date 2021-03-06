package spring.mvc.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//Show form method
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-Form";
	}
	
	//Process the form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	
	//New control method
	@RequestMapping("/processFormVersion2")
	public String shout(HttpServletRequest request, Model model){
		String stuName = request.getParameter("studentName");
		stuName = stuName.toUpperCase();
		String result = "Yo" + stuName;
		
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
	//RequestParam annotation
	@RequestMapping("/processFormVersion3")
	public String shout3(@RequestParam("studentName") String theName, Model model){
		theName = theName.toUpperCase();
		String result = "Yo! " + theName;
		
		model.addAttribute("message", result);
		return "helloworld";
	}
}
