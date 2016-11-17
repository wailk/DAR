package dar.services;

import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.SessionFactory;

import dar.core.Appartements;
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
	
	
	public static Users getbyIdApp(int id){
		Appartements a = AppartServices.getAppartbyId(id);
		return a .getUser() ;
	}


	public static void sendmail(String login, int id_appart, String content) throws MessagingException {
		// TODO Auto-generated method stub
		Appartements a = AppartServices.getAppartbyId(id_appart);
		String adresse = a.getAdresse();
		String user_email = a.getUser().getEmail();
		MailUtil.sendMail(adresse, login, user_email, content);
	}
		
	public static void main(String[] args) throws MessagingException{
		
		//UsersServices.sendmail("login",1,"bonjour c'est toujours disponible ? ");
	}
		
	

}
