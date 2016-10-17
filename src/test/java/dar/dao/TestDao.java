package dar.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import dar.core.Users;
import dar.utils.HandleHibernate;
import dar.utils.dbProfilTools;

public class TestDao {

	@Test
	public void testUser() {

		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		Users us1 = new Users();
		dbProfilTools tool = new dbProfilTools();
//		System.out.println(tool.getUser("ash.mootezgmail.com", "1234").getFirstname());
//		System.out.println(userDao.getAll(Users.class));
		us1.setName("Hichri");
		us1.setMdp("1234");
		us1.setFirstname("ash");
		us1.setEmail("ash.mootezgmail.com");
		userDao.save(us1);

		System.out.println(">>>>>>" + userDao.getElement(Users.class,1));
//		
//		
//		
//		//Session session = sf.openSession();
//		
//		List<Users> list_users =  (List<Users>)sf.createQuery("from Users where mdp = 1234 and email = 'ash.mootezgmail.com'").list() ;
//		System.out.println(">>>>>>>>>>   "   +list_users.get(0).getFirstname());
	sf.close();
	}
	
	

}
