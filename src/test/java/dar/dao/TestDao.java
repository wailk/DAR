package dar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import dar.core.Users;

public class TestDao {

	@Test
	public void testUser() {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(cf.getProperties());
		ServiceRegistry sr = srb.build();
		SessionFactory sf = cf.buildSessionFactory(sr);
		UserDao userDao = new UserDao(sf);
		Users us1 = new Users();
		us1.setName("Hichri");
		us1.setFirstname("Mootez");
		us1.setEmail("hichri.mootezgmail.com");

		System.out.println(">>>>>>" + userDao.getElement(Users.class,1));
		sf.close();
	}
	
	

}
