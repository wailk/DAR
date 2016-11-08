package dar.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "Equipements")
public class Equipements {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_equipement;
	
	@Column(name = "name", length = 100)
	@Expose private String nom;
	@Column(name = "type", length = 45)
	@Expose private String type;
	@Column(name = "laltitude", length = 45)
	@Expose private String laltitude;
	@Column(name = "longitude", length = 45)
	@Expose private String longitude;
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
	public String getLaltitude() {
		return laltitude;
	}
	public void setLaltitude(String laltitude) {
		this.laltitude = laltitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	@Override
	public String toString() {
		return "Equipement [nom=" + nom + ", type=" + type + ", latitude=" + laltitude
				+ ", type=" + type + ", longitude=" + longitude + "]";
	}
	
	

}
