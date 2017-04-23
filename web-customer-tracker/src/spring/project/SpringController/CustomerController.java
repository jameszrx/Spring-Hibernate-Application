package spring.project.SpringController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.project.dao.CustomerDAO;
import spring.project.entity.Customer;
import spring.project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*//Inject the DAO into controller
	@Autowired
	private CustomerDAO customerDAO;
	No longer needed, the new layer - service layer will be needed*/
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		//Get customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add them to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		//Create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		//Save customer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") String theID, Model theModel){
		//Get the customer from the database using theID (major key)
		Customer theCustomer = customerService.getCustomer(theID);
		
		//Set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") String theID, Model theModel){
		// Delete the customer
		customerService.deleteCustomer(theID);
		return "redirect:/customer/list";
	}
}