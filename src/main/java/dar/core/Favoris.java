package dar.core;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.annotations.Expose;



@Entity
@Table(name = "Favoris")
public class Favoris {
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_favoris;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user",referencedColumnName="id_user")
	private Users id_user;
	

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}



	@ManyToMany(fetch = FetchType.EAGER)
	@Expose
	private Set<Appartements> appartements;
	
	public Set<Appartements> getAppartemens() {
		return appartements;
	}

	public void setAppartemens(Set<Appartements> appartemens) {
		this.appartements = appartemens;
	}
	public void addAppartemens(Appartements app) {
		this.appartements.add(app);
	}
	
	
	public JSONObject toJSON(){
		JSONObject res = new JSONObject();
		JSONArray arr = new JSONArray();
		arr.put(this.id_user.getId_user());
		for(Appartements a : appartements)
		arr.put(a.toJSON());
		
		res.put("apps", arr);
		
		
		return res;
	}



}