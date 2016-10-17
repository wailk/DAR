package dar.dao;

import org.hibernate.SessionFactory;

import dar.core.Appartements;
import dar.core.Users;

public class AppartementDao extends CrudDao<Appartements>{

	public AppartementDao(SessionFactory sf) {
		super(sf);
	}

}
