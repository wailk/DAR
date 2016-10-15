package dar.core;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id() 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id_user;

	@Column(name = "name", length = 45)
	private String name;
	@Column(name = "firstname", length = 45)
	private String firstname;
	@Column(name = "email", length = 45)
	private String email;
	@Column(name = "telephone", length = 45)
	private String telephone;
	@Column(name = "mdp", length = 45)
	private String mdp;

//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="appart_id")
	private ArrayList<Appartements> appartemens ; 
	
	public ArrayList<Appartements> getAppartemens() {
		return appartemens;
	}

	public void setAppartemens(ArrayList<Appartements> appartemens) {
		this.appartemens = appartemens;
	}

	public Users() {
	}

	public Users(String name) {
		this.name = name;
	}
	

	public Users(String name, String firstname, String email, String telephone, String mdp) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.telephone = telephone;
		this.mdp = mdp;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}



}
