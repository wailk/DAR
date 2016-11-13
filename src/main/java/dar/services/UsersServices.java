package dar.services;

import java.util.List;

import org.hibernate.SessionFactory;

import dar.core.Users;
import dar.dao.UserDao;
import dar.utils.HandleHibernate;

public class UsersServices {
	
	
	
	public static boolean exist(String email){
		
		
		
		SessionFactory	sf = HandleHibernate.getSF() ;
		UserDao appdao= new UserDao(sf);
		String query = "from Users where email = '"+email + "'";
		List<Users> Users = appdao.getFromQuery(query);
		if(Users.isEmpty() ) return false ;
		return true ;
		
	}

}
