package dar.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dar.core.Users;
import dar.dao.UserDao;
import java.util.*;

public class dbProfilTools {
	
	

	@SuppressWarnings("unchecked")
	public static Users getUser(String pseudo,String pass){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> list =  userDao.getFromQuery("from Users where mdp ="+ pass + "and email = " +"'"+pseudo +"'");
	       return list.get(0);
	}
	
	
		public static void deleteUser(int id_profil){

	}


}
