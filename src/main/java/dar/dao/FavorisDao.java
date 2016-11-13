package dar.dao;

import org.hibernate.SessionFactory;
import dar.core.Favoris;

public class FavorisDao   extends CrudDao<Favoris>{

	public FavorisDao(SessionFactory sf) {
		super(sf);
	}
}
