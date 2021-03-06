package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//Create Sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try{			
			session.beginTransaction();
			
			//Query student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//Display student
			for(Student tempst : theStudents){
				System.out.println(tempst);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally{
			factory.close();
		}
	}

}
