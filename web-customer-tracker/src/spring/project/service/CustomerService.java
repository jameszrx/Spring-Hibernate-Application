package spring.project.service;

import java.util.List;

import spring.project.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(String theID);

	public void deleteCustomer(String theID);
}