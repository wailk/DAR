package dar.dao;

import org.hibernate.SessionFactory;

import dar.core.Users;

public class UserDao extends CrudDao<Users>{

	public UserDao(SessionFactory sf) {
		super(sf);
	}
	

}
