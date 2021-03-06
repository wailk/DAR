package dar.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.json.JSONObject;


@Entity
@Table(name = "Photos")
public class Photos {
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_photo;

//	@ManyToOne
//	@ForeignKey(name="appart_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appartement",referencedColumnName="id_appartement")
	private Appartements id_appartement;
	@Column(name = "chemin", length = 100)
	private String chemin;
	public int getId_photo() {
		return id_photo;
	}
	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}
	
	
	public Appartements getAppartement() {
		return id_appartement;
	}
	public void setAppartement(Appartements appartement) {
		this.id_appartement = appartement;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	public JSONObject toJSON(){
		JSONObject obj = new JSONObject();
		
		
		return obj;
		
	}



}