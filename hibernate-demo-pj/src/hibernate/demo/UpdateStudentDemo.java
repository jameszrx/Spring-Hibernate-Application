package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//Create Sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try{
			int studentID = 1;
			
			//new code
			System.out.println("Saved ID " + studentID);
			
			//get a new session
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentID);
			
			System.out.println("Updating student...");
			
			myStudent.setFirstName("kobe");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally{
			factory.close();
		}
	}

}
