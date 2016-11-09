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
import org.json.JSONObject;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "Appartements")
public class Appartements implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	// JSON keys
	
	private static final String KEY_USER_ID = "user_id";
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_TYPE = "type";
	private static final String KEY_AREA_SIZE = "area";
	private static final String KEY_FURNITURE = "furnished";
	private static final String KEY_RENT = "rent";
	
	
	
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_appartement;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user",referencedColumnName="id_user")
	@Expose private Users id_user;
	@Column(name = "adresse", length = 100)
	@Expose private String adresse;
	@Column(name = "type", length = 45)
	@Expose private String type;
	@Column(name = "superficie", length = 45)
	@Expose private int superficie;
	@Column(name = "meuble")
	@Expose private boolean meuble;
	@Column(name="loyer")
	@Expose private double loyer ;
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "id_appartement")
	private Set<Photos> photos ;
	
	
	public Set<Photos> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photos> photos) {
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
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
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
	
	@Override
	public String toString() {
		return "Appartements [id_appartement=" + id_appartement + ", id_user=" + id_user + ", adresse=" + adresse
				+ ", type=" + type + ", superficie=" + superficie + ", meuble=" + meuble + ", loyer=" + loyer
				+ ", photos=" + photos + "]";
	}
	
	
	public JSONObject toJSON(){
		JSONObject res = new JSONObject();
		res.put(KEY_ADDRESS, adresse);
		res.put(KEY_AREA_SIZE, superficie);
		res.put(KEY_FURNITURE, meuble);
		res.put(KEY_RENT, loyer);
		res.put(KEY_TYPE, type);
		res.put(KEY_USER_ID, id_user.getId_user());
		return res;
	}
	
	
	
}

