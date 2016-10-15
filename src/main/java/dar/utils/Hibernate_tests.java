package dar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import dar.core.User;
import dar.utils.HandleHibernate;



public class TestUser {
	
	@Test
	public void test() {
		SessionFactory sessionFactory = null;
		Session session = null;
		List<Class<?>> ls = new ArrayList<>();
		ls.add(User.class);
		// Initialize sessionFactory
		sessionFactory = HandleHibernate.initSessionFactory(ls);
		// Get ;Session
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		String hsq = "from User as t";
		User user1 = new User("mootez","hichri","hichri@gmail.com","0602","mdp");
		session.save(user1);
		//List<User> tbs =  session.createQuery(hsq).list();
		//System.out.println(tbs);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}

}
