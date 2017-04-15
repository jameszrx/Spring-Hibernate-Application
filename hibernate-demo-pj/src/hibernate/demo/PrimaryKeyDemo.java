package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try{
			Student temp1 = new Student("George", "Hill", "ghill@gmail.com");
			Student temp2 = new Student("Lebron", "James", "lbj@gmail.com");
			Student temp3 = new Student("Shaq", "O'Neal", "sqo@gmail.com");
			
			session.beginTransaction();
			
			session.save(temp1);
			session.save(temp2);
			session.save(temp3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally{
			factory.close();
		}

	}

}
