package dar.services;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import dar.core.Appartements;
import dar.core.Favoris;
import dar.dao.FavorisDao;
import dar.utils.HandleHibernate;
import dar.utils.dbProfilTools;

public class ViewServices {
	
	public static String getAppartmentBySession(HttpSession session){
		String login_user=(String) session.getAttribute("user") ;
		int  id_user = dbProfilTools.getUser(login_user).getId_user() ;  

		List<Appartements> appartements= AppartServices.getByUserId(id_user);
		
		String out = "";
		for(Appartements a : appartements)
			out += "<li>"+ a.getAdresse()  +"</li>\n";
		
		return out;
	}
	
	public static String getFavorisBySession(HttpSession session){
		String login_user=(String) session.getAttribute("user") ;
		int  id_user = dbProfilTools.getUser(login_user).getId_user(); 
		
		String out = "";
		for(Appartements a : FavorisServices.getAppsFromFavoris(id_user))
			out += "<li>"+ a.getAdresse()  +"</li>\n";
		
		return out;
	}

}
