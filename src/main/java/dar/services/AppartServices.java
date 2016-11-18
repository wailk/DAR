package dar.services;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dar.api.HttpURLConn;
import dar.core.Appartements;
import dar.core.Photos;
import dar.core.Users;
import dar.dao.AppartementDao;
import dar.dao.PhotoDao;
import dar.utils.HandleHibernate;

public class AppartServices {

	public static void addAppart(Users user, String adresse, double loyer, int superficie, String type, boolean meuble,
			int cd, String chemin) throws JSONException, Exception {

		Appartements app = new Appartements();
		app.setAdresse(adresse);
		app.setLoyer(loyer);
		app.setMeuble(meuble);
		app.setUser(user);
		app.setSuperficie(superficie);
		app.setType(type);
		traitementGoogleGeo(app, adresse);
		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		appdao.save(app);
		if (!"".equals(chemin)) {
			addPhoto(chemin, app);
		}
	}

	public static void addPhoto(String chemin, Appartements app) {
		Photos p = new Photos();
		p.setChemin(chemin);
		p.setAppartement(app);
		PhotoDao photoDao = new PhotoDao(HandleHibernate.getSF());
		photoDao.save(p);
	}

	public static Appartements getAppartbyId(int id) {
		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		String query = "from Appartements where id_appartement =" + id;
		List<Appartements> appartements = appdao.getFromQuery(query);
		return appartements.get(0);

	}

	private static void traitementGoogleGeo(Appartements app, String adresse) throws JSONException, Exception {
		HttpURLConn http = new HttpURLConn();
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(adresse, "UTF-8")
				+ "&key=AIzaSyBEJXY0rT2TT2ZR8IdYAhuEvj18DJahQ50";
		String response = http.sendGet(url);
		JSONObject hole = new JSONObject(response.toString());
		JSONArray results = (JSONArray) hole.get("results");

		JSONObject geo = results.getJSONObject(0).getJSONObject("geometry");
		BigDecimal lalt = geo.getJSONObject("location").getBigDecimal("lat");
		BigDecimal longi = geo.getJSONObject("location").getBigDecimal("lng");
		app.setLatitude(lalt);
		app.setLongitude(longi);

	}

	public static void main(String[] args) throws JSONException, Exception {
		// traitementGoogleGeo(new Appartements(), "81 avenue de la bourdonnais
		// 75007 paris");
		// System.out.println( getAppartbyId(487).toString());
//		List<Appartements> app = getByUserId(4);
//		List<Appartements> apsp = getByUserId(1);
//		JSONArray arr = new JSONArray();
//		for (Appartements a : app)
//			arr.put(a.toJSON());
//		System.out.println(arr.toString());
	}

	public static void suppAppart(int id) {

		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		Appartements app = appdao.getElement(Appartements.class, id);
		appdao.removeElement(app);
	}

	public static List<Appartements> search(String prix_max, String prix_min, String code) {

		Map<String, String> map = new HashMap<String, String>();
		String query = "";
		if (prix_min != "0")
			query = "loyer > " + prix_min;
		if (prix_max != "0")
			query = query + "loyer < " + prix_max;
		if (code != "0")
			query = query + "codepostal =" + code;

		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		List<Appartements> list_app = appdao.getFromQuery(query);
		return list_app;

	}

	public static List<Appartements> getByUserId(int id) {

		String query = "";
		query = "from Appartements where id_user = " + id;

		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		List<Appartements> list_app = appdao.getFromQuery(query);
		return list_app;

	}

}
