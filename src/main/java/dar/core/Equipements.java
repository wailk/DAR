package dar.core;

import java.math.BigDecimal;

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
	
	

}
