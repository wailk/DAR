package dar.services;

import org.hibernate.SessionFactory;

import dar.core.Appartements;
import dar.core.Users;
import dar.dao.AppartementDao;
import dar.utils.HandleHibernate;

public class AppartServices {
	
	
	public static void addAppart(Users user,String adresse,double loyer ,boolean meuble){
		
		Appartements app = new Appartements();
		app.setAdresse(adresse);
		app.setLoyer(loyer);
		app.setMeuble(meuble);
		app.setUser(user);
		SessionFactory	sf = HandleHibernate.getSF() ;
		AppartementDao appdao= new AppartementDao(sf);
		appdao.save(app);
		
		
		
	}
	
	
	
	

}
