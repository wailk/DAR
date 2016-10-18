package dar.utils;


import org.hibernate.SessionFactory;


import dar.core.Users;
import dar.dao.UserDao;
import java.util.*;

public class dbProfilTools {
	
	


	public static Users getUser(String pseudo,String pass){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> list =  userDao.getFromQuery("from Users where mdp ="+ pass + "and email = " +"'"+pseudo +"'");
	       return list.get(0);
	}
	
	
	
	public static void addUser(Users user){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		userDao.save(user);
		
		
	}
	
	
		public static void deleteUser(int id_profil){
			

	}


}
