package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.projecthibernate.Users;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session =factory.getCurrentSession();
		
		try {
			//create object of entity class type 
			Users user = new Users();
			//Users user = new Users(7,"mohammed","rizwan","mohammedrizwan1985@gmail.com");
			
			//start transaction
			session.beginTransaction();
			//Perform operation
		     //session.save(user);
			user = session.get(Users.class,6);
			
			//Updating object
			//user.setUser_lname("ruman");
			
			//deleting object
			session.delete(user);
			//commit the transaction 
			session.getTransaction().commit();
			System.out.println(user);
			//System.out.println(user);
		}finally {
			session.close();
			factory.close();
	
		}

	}

}
