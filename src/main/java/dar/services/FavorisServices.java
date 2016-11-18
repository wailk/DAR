package dar.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.json.JSONException;

import dar.core.Appartements;
import dar.core.Favoris;
import dar.core.Users;
import dar.dao.AppartementDao;
import dar.dao.FavorisDao;
import dar.utils.HandleHibernate;
import dar.utils.dbProfilTools;

public class FavorisServices {

	
		
public static void	updateFavoris(Favoris f){
		SessionFactory sf = HandleHibernate.getSF();
		FavorisDao favdao = new FavorisDao(sf);
		favdao.update(f);
	}

	public static void newFavoris(Users user, Appartements app) {

		Favoris fav = new Favoris();
		fav.setId_user(user);
		Set<Appartements> list = new HashSet<Appartements>();
		list.add(app);
		fav.setAppartemens(list);
		SessionFactory sf = HandleHibernate.getSF();
		FavorisDao favdao = new FavorisDao(sf);
		favdao.save(fav);

	}
	
	public static void main(String[] args) throws JSONException, Exception{
		//traitementGoogleGeo(new Appartements(), "81 avenue de la bourdonnais 75007 paris");
		//System.out.println( getAppartbyId(487).toString());
		//traitementFavoris("david@gmail.com",6);
		//Favoris fav = getFavoris("david@gmail.com");
		  //System.out.println(getAppsFromFavoris(4).get(0).toJSON());
		//System.out.println(fav.toJSON());
	}

	public static void traitementFavoris(String login,int id_appart) {
		
		Users user = dbProfilTools.getUser(login);
		Appartements app = AppartServices.getAppartbyId(id_appart);
		Favoris fav = user.getFavoris();
		if(fav != null){
			fav.addAppartemens(app);
			FavorisServices.updateFavoris(fav);
			System.out.println("update favoris de " + login);
		}else {
			newFavoris(user,app);
		}
		
		
	}
//
	public static List<Appartements> getAppsFromFavoris(int id){
		List<Appartements> listappartements = new ArrayList<Appartements>();
		Users user = dbProfilTools.getUser(id);
		Favoris fav = user.getFavoris();
		System.out.println("Renvoie de la liste de favoris " + id);
	
		SessionFactory	sf = HandleHibernate.getSF() ;
		FavorisDao favdao= new FavorisDao(sf);
		String query = "from Favoris where id_user ="+user.getId_user();
		List<Favoris> favoris = favdao.getFromQuery(query);
		if(favoris.isEmpty())
				return listappartements;
		List<Object> listapp = Arrays.asList(favoris.get(0).getAppartemens().toArray());
		
		for(Object x : listapp){
			listappartements.add((Appartements)x);
		}
		return listappartements;
	}
	
	public static Favoris getFavoris(String login) {
		Users user = dbProfilTools.getUser(login);
		Favoris fav = user.getFavoris();
		System.out.println("Renvoie de la liste de favoris " + login);
	
		SessionFactory	sf = HandleHibernate.getSF() ;
		FavorisDao favdao= new FavorisDao(sf);
		String query = "from Favoris where id_user ="+user.getId_user();
		List<Favoris> favoris = favdao.getFromQuery(query);
		return favoris.get(0);
		
		
	}

}
