package dar.api;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dar.core.Equipements;
import dar.dao.EquipementDao;
import dar.utils.HandleHibernate;

public class ImportEquipement {
	
	
	public void traitement_1(String response){
		SessionFactory sf = HandleHibernate.getSF();
		Equipements eq = null ;
		JSONObject hole = new JSONObject(response.toString());
		JSONArray records = (JSONArray) hole.get("records");
		
		for (int i = 0; i < records.length(); i++) {
			// System.out.println(records.getJSONObject(i));
			 JSONObject fields  = (JSONObject) records.getJSONObject(i).get("fields");
			 JSONArray geo_shape =  (JSONArray) ((JSONObject) fields.get("geo_shape")).get("coordinates");
			 String name = fields.getString("ins_nom");
			// System.out.println("name  "+name);
			 
			 BigDecimal laltitude =   geo_shape.getBigDecimal(1);
			System.out.println("laltitude  "+laltitude);
			 BigDecimal longitude =  geo_shape.getBigDecimal(0);
			 System.out.println("longitude  "+longitude);
			 

				EquipementDao eqDao = new EquipementDao(sf);
				eq = new Equipements();
				eq.setNom(name);
				eq.setLaltitude(laltitude);
				eq.setLongitude(longitude);
				eq.setType("sport");
				eqDao.save(eq);
			 
			 
			}
		HandleHibernate.close();

		
	}
	
	
	public void traitement_2(String response){
		SessionFactory sf = HandleHibernate.getSF();
		Equipements eq = null ;
		JSONObject hole = new JSONObject(response.toString());
		JSONArray records = (JSONArray) hole.get("records");
		
		for (int i = 0; i < records.length(); i++) {
			// System.out.println(records.getJSONObject(i));
			 JSONObject fields  = (JSONObject) records.getJSONObject(i).get("fields");
	
			 JSONArray geo_shape =  (JSONArray) ((JSONObject) records.getJSONObject(i).get("geometry")).get("coordinates");
			 String name = fields.getString("enseigne");
			// System.out.println("name  "+name);
			 
			 BigDecimal laltitude =   geo_shape.getBigDecimal(1);
			//System.out.println("laltitude  "+laltitude);
			 BigDecimal longitude =  geo_shape.getBigDecimal(0);
			 //System.out.println("longitude  "+longitude);
			 

				EquipementDao eqDao = new EquipementDao(sf);
				eq = new Equipements();
				eq.setNom(name);
				eq.setLaltitude(laltitude);
				eq.setLongitude(longitude);
				eq.setType("cinema");
				eqDao.save(eq);
			 
			 
			}
		HandleHibernate.close();

		
	}
	
	
	
	public static void main(String[] args) throws Exception {

		String url = "http://data.iledefrance.fr/api/records/1.0/search/?dataset=installations_sportives2016&facet=ins_insee&facet=fam_nb";
		HttpURLConn http = new HttpURLConn();
		ImportEquipement im = new ImportEquipement();
		//System.out.println("Testing 1 - Send Http GET request");
		im.traitement_1(http.sendGet(url));
		//System.out.println("Testing 1 - Send Http GET request");
		String url2 = "http://data.iledefrance.fr/api/records/1.0/search/?dataset=les_salles_de_cinemas_en_ile-de-france&facet=dep&facet=adrcommune";
		im.traitement_2(http.sendGet(url2));

//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();

	}
	
	
	
	//to json 
			
}
