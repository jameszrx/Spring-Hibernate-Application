package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//Create Sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try{
			Student temp = new Student("Doug", "Rivers", "dr@gmail.com");
			
			session.beginTransaction();
			
			session.save(temp);
			
			session.getTransaction().commit();
			
			//new code
			System.out.println("Saved ID " + temp.getId());
			
			//get a new session
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, temp.getId());
			
			System.out.println("Get complete" + myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally{
			factory.close();
		}
	}

}
