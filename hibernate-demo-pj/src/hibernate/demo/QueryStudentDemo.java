package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create Sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try{
			Student temp = new Student("George", "Hill", "ghill@gmail.com");
			
			session.beginTransaction();
			
			session.save(temp);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally{
			factory.close();
		}
	}

}
