package dar.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "Appartements")
public class Appartements implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_appartement;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user",referencedColumnName="id_user")
	private Users id_user;
	@Column(name = "adresse", length = 100)
	private String adresse;
	@Column(name = "type", length = 45)
	private String type;
	@Column(name = "superficie", length = 45)
	private String superficie;
	@Column(name = "meuble")
	private boolean meuble;
	@Column(name="loyer")
	private double loyer ;
	
	
//	@JoinColumn(name="photo_id")
	private ArrayList<Photos> photos =  new  ArrayList<Photos>() ;
	
	//@OneToMany(cascade=CascadeType.ALL,mappedBy = "Appartements")
	public ArrayList<Photos> getPhotos() {
		return photos;
	}
	public void setPhotos(ArrayList<Photos> photos) {
		this.photos = photos;
	}
	public int getId_appartement() {
		return id_appartement;
	}
	public void setId_appartement(int id_appartement) {
		this.id_appartement = id_appartement;
	}
	
	public Users getUser() {
		return id_user;
	}
	public void setUser(Users user) {
		this.id_user = user;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public boolean isMeuble() {
		return meuble;
	}
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}
	public double getLoyer() {
		return loyer;
	}
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}
	
	
	
}
