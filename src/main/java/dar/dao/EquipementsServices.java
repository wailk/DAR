package dar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dar.api.HttpURLConn;
import dar.core.Equipements;
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
		query = query.substring(1);

		url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + laltitude + "," + longitude
				+ "&destinations=" + query + "&language=fr-FR&key=AIzaSyDkAuDP6CUy_2YfF24qmVB0fIC8o3-WYfQ";
		return traitement(http.sendGet(url), Equipements);

	}

	private static JSONArray traitement(String response, List<Equipements> equipements) {

		JSONArray res = new JSONArray();
		JSONObject hole = new JSONObject(response.toString());
		JSONArray records = (JSONArray) hole.get("rows");

		// System.out.println(records.getJSONObject(i));
		JSONArray elements = (JSONArray) records.getJSONObject(0).get("elements");
		for (int i = 0; i < elements.length(); i++) {

			JSONObject distance = (JSONObject) (((JSONObject) elements.get(i)).get("distance"));
			double value = distance.getDouble("value");
			if (value < 1600) {

				JSONObject j = equipements.get(i).toJSON();
				j.put("adresse", ((JSONArray) hole.get("destination_addresses")).getString(i));
				j.put("distance", distance.get("texte"));

				res.put(j);
			}

		}
		return res;
	}
}
