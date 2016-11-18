package dar.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	private static final String KEY_LOCATION = "location";
	
	
	
	
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
	private int superficie;
	@Column(name = "meuble")
	private boolean meuble;
	@Column(name="loyer")
	private double loyer ;
	@Column(name = "laltitude",  precision = 19, scale = 4)
	@Expose private BigDecimal latitude;
	@Column(name = "longitude",  precision = 19, scale = 4)
	@Expose private BigDecimal longitude;
	@Column(name="codepostal", length = 45)
	private String codepostal ;
	
	
	public String code_postal() {
		return codepostal;
	}
	public void code_postal(String c) {
		this.codepostal = c;
	}


	@OneToMany(fetch = FetchType.EAGER,mappedBy = "id_appartement")
	private Set<Photos> photos ;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	private Set<Favoris> favoris ;
	
	
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
	
	
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Appartements [id_appartement=" + id_appartement + ", id_user=" + id_user + ", adresse=" + adresse
				+ ", type=" + type + ", superficie=" + superficie + ", meuble=" + meuble + ", loyer=" + loyer
				+ ", photos=" + photos + "]";
	}
	
	
	public JSONObject toJSON(){
		JSONObject res = new JSONObject();
		res.put("id", id_appartement);
		res.put(KEY_ADDRESS, adresse);
		res.put(KEY_AREA_SIZE, superficie);
		res.put(KEY_FURNITURE, meuble);
		res.put(KEY_RENT, loyer);
		res.put(KEY_TYPE, type);
		JSONObject loc = new JSONObject();
		loc.put("lat", latitude);
		loc.put("lng", longitude);
		res.put(KEY_LOCATION, loc);
		res.put(KEY_USER_ID, id_user.getId_user());
		return res;
	}
	
	
	
}

