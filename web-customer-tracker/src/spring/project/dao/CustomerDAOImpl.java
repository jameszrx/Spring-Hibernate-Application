package spring.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory; //Corresponds to bean ID.
	
	// Get all and sort them by last name
	@Override
	public List<Customer> getCustomers() {
		//Get the session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", 
				Customer.class);
		
		//Get the result
		List<Customer> customers = theQuery.getResultList();
		
		//Return the list
		return customers;
	}

	@Override
	public void savaCustomer(Customer theCustomer) {
		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Save the customer to the DB
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(String theID) {
		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get the customer using the ID
		Customer theCustomer = currentSession.get(Customer.class, theID);
		//return currentSession.get(Customer.class, theID);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(String theID) {
		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerID");
		theQuery.setParameter("customerID", theID);
		
		theQuery.executeUpdate();
		
	}

}
