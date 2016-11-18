package dar.dao;

import org.hibernate.SessionFactory;

import dar.core.Photos;

public class PhotoDao extends CrudDao<Photos>{

	public PhotoDao(SessionFactory sf) {
		super(sf);
	}

}
