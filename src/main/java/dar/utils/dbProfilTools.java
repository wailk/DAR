package dar.utils;


import org.hibernate.SessionFactory;


import dar.core.Users;
import dar.dao.UserDao;
import java.util.*;

public class dbProfilTools {
	
	


	public static Users getUser(String pseudo,String pass){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> list =  userDao.getFromQuery("from Users where mdp = "+"'"+ pass +"'"+" and email = " +"'"+pseudo +"'");
	       return list.get(0);
	}
	public static boolean existUser(String pseudo,String pass){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> list =  userDao.getFromQuery("from Users where mdp = "+"'"+ pass +"'"+" and email = " +"'"+pseudo +"'");
	       return list.size() != 0;
	}
	
	public static Users getUser(String email){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> users =  userDao.getFromQuery("from Users where email = " +"'"+email +"'");
	       return users.get(0);
	}
	public static Users getUser(int id){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		List<Users> users =  userDao.getFromQuery("from Users where id_user = " +id);
	       return users.get(0);
	}
	
	
	public static void addUser(Users user){
		SessionFactory sf = HandleHibernate.getSF();
		UserDao userDao = new UserDao(sf);
		userDao.save(user);
		
		
	}
	
	
	public static void main(String[] args){
		
		Users us = getUser("david@gmail.com","mootez");
		us.toString();
	}
	
		public static void deleteUser(int id_profil){
			

	}


}
