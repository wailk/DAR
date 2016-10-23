package dar.dao;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dar.core.Users;
import dar.utils.HandleHibernate;

public class TestDao {
	static SessionFactory sf = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sf = HandleHibernate.getSF();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		HandleHibernate.close();
	}

	@Test
	public void testUser() {

		UserDao userDao = new UserDao(sf);
		Users us1 = new Users();
		us1.setName("Hichri");
		us1.setMdp("1234");
		us1.setFirstname("ash");
		us1.setEmail("ash.mootezgmail.com");
		userDao.save(us1);
	}

	@Test
	public void testGetElem() {
		UserDao userDao = new UserDao(sf);
		Users us1 = userDao.getElement(Users.class, 1);
		System.out.println(">>>> testGetElem : " + us1);
	}

	@Test
	public void testRequete() {
		UserDao userDao = new UserDao(sf);
		HashMap<String, String> req = new HashMap<>();
		req.put("email", "zak@gamil.com");
		Users us1 = userDao.getFromQuery(Users.class, req).get(0);
		System.out.println(">>>> testRequete : " + us1);
	}

}
