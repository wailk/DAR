package dar.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dar.api.HttpURLConn;
import dar.core.Equipements;
import dar.dao.EquipementDao;
import dar.utils.HandleHibernate;

public class EquipementsServices {

	public static JSONArray getNearby(String laltitude, String longitude) throws Exception {

		HttpURLConn http = new HttpURLConn();
		String url, query = "";

		SessionFactory sf = HandleHibernate.getSF();
		EquipementDao appdao = new EquipementDao(sf);
		List<Equipements> Equipements = appdao.getAll(Equipements.class);

		for (Equipements e : Equipements) {
			query = query + "|" + e.getLaltitude() + "," + e.getLongitude();

		}
		System.out.println(query);
		query = query.substring(1);
		System.out.println(query);

		url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + laltitude + "," + longitude
				+ "&destinations=" + query + "&language=fr-FR&key=AIzaSyDkAuDP6CUy_2YfF24qmVB0fIC8o3-WYfQ";
	
		return traitement(http.sendGet(url), Equipements);

	}

	private static JSONArray traitement(String response, List<Equipements> equipements) {
		System.out.println("depaar traitementt");
		JSONArray res = new JSONArray();
		JSONObject hole = new JSONObject(response.toString());
		JSONArray rows = (JSONArray) hole.get("rows");
		

		// System.out.println(records.getJSONObject(i));
		JSONArray elements =  rows.getJSONObject(0).getJSONArray("elements");
		for (int i = 0; i < elements.length(); i++) {
			//System.out.println("im heeereee");
			JSONObject distance = (JSONObject) (((JSONObject) elements.getJSONObject(i)).get("distance"));
			int value = (int) distance.get("value");
			//System.out.println(value);
			if (value < 7000) {

				JSONObject j = equipements.get(i).toJSON();
				j.put("adresse", ((JSONArray) hole.get("destination_addresses")).getString(i));
				j.put("distance", distance.getString("text"));

				res.put(j);
			}

		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		
		JSONArray eqs = getNearby("48.845636","2.355060"); 
		 System.out.println(eqs.toString());	
		
		
	}
}
