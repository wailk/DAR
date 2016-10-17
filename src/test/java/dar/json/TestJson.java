package dar.json;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dar.core.Users;
import dar.dao.UserDao;
import dar.utils.HandleHibernate;

public class TestJson {

	@Test
	public void testJavaToJson() {
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		Users user = userDao.getElement(Users.class, 1);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		System.out.println("Json >>>>>>>>" + gson.toJson(user));
		sf.close();
	}

	@Test
	public void testJsonToJava() {
		String json = "{\"id_user\":1,\"name\":\"Hichri\","
				+ "\"firstname\":\"ash\",\"email\":\"ash.mootezgmail.com\",\"mdp\":\"1234\",\"appartements\":[]}";
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Users user = gson.fromJson(json,Users.class);
		
		System.out.println("java user >>>>>" + user);

	}

}
