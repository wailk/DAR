package dar.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id()
	@GeneratedValue
	private int id_user;

	@Column(name = "name", length = 45)
	private String name;

	private String firstname;
	private String email;

	private String telephone;
	private String mdp;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}
	

	public User(String name, String firstname, String email, String telephone, String mdp) {
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
