package dar.core;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "Equipements")
public class Equipements {
	
	
	
	
	// JSON keys
	

		public static final String KEY_TYPE = "type";
		public static final String KEY_NAME = "name";
		public static final String KEY_LALTITUDE = "laltitude";
		public static final String KEY_LONGITUDE = "longitude";
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_equipement;
	
	@Column(name = "name", length = 100)
	@Expose private String nom;
	
	@Column(name = "adresse", length = 100)
	@Expose private String adresse;
	@Column(name = "type", length = 45)
	@Expose private String type;
	@Column(name = "laltitude",  precision = 19, scale = 4)
	@Expose private BigDecimal laltitude;
	@Column(name = "longitude",  precision = 19, scale = 4)
	@Expose private BigDecimal longitude;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getLaltitude() {
		return laltitude;
	}
	public void setLaltitude(BigDecimal laltitude2) {
		this.laltitude = laltitude2;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	
	@Override
	public String toString() {
		return "Equipement [nom=" + nom + ", type=" + type + ", latitude=" + laltitude
				+ ", type=" + type + ", longitude=" + longitude + "]";
	}
	
	public JSONObject toJSON(){
		JSONObject res = new JSONObject();
		res.put(KEY_NAME, this.nom);
		res.put(KEY_TYPE, type);
		res.put(KEY_LALTITUDE,laltitude);
		res.put(KEY_LONGITUDE,longitude);
		
		return res;
	}
	
	
	

}
