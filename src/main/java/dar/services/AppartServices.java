package dar.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static void suppAppart(int id){
		
		SessionFactory	sf = HandleHibernate.getSF() ;
		AppartementDao appdao= new AppartementDao(sf);
		Appartements app = appdao.getElement(Appartements.class, id);
		appdao.removeElement(app);
		
		
		
		
		
	}

	public static List<Appartements> search(String prix_max, String prix_min, String ville) {
		
		Map<String, String> map = new HashMap<String,String>();
		String query = "";
		if(prix_min != "0") query = "loyer > "+prix_min;
		if(prix_max != "0") query = query + "loyer < "+prix_max;
		if(ville != "0") query = query + "ville ="+ville;
		
		SessionFactory	sf = HandleHibernate.getSF() ;
		AppartementDao appdao= new AppartementDao(sf);
		List<Appartements> list_app = appdao.getFromQuery(query);
		return list_app ;
		
		
	}
	
	
	
	

}
