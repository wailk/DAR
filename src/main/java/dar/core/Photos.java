package dar.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "Photos")
public class Photos {
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_photo;

//	@ManyToOne
//	@ForeignKey(name="appart_id")
	private Appartements appartement;
	@Column(name = "chemin", length = 100)
	private String chemin;
	public int getId_photo() {
		return id_photo;
	}
	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}
	
	public Appartements getAppartement() {
		return appartement;
	}
	public void setAppartement(Appartements appartement) {
		this.appartement = appartement;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}








}