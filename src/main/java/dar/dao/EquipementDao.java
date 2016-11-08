package dar.dao;

import org.hibernate.SessionFactory;

import dar.core.Equipements;


public class EquipementDao  extends CrudDao<Equipements>{

	public EquipementDao(SessionFactory sf) {
		super(sf);
	}
	

}
