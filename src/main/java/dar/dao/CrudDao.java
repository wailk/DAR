package dar.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CrudDao<T> {

	private SessionFactory sf;
	private Session session ;

	public CrudDao(SessionFactory sf) {
		super();
		this.sf = sf;
		//session = sf.openSession();
	}

	public T getElement(Class clazz, int id) {
		T elem;
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println(">>>>>>" + getClass());
		elem = (T) session.get(clazz, id);
		tx.commit();
		//session.close();
		return elem;
	}

	public void removeElement(T objet) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(objet);
		tx.commit();
		//session.close();
	}

	public List<T> getAll(Class clazz) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> list = (List<T>) session.createQuery("from " + clazz.getName()).list();
		tx.commit();
		//session.close();
		return list;
	}

	public void save(T elem) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(elem);
		tx.commit();
		//session.close();
	}

	public void update(T elem) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(elem);
		tx.commit();
		//session.close();
	}
	public List<T> getFromQuery(String q) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> list = (List<T>) session.createQuery(q).list();
		tx.commit();
		//session.close();
		return list;

	}

	public List<T> getFromQuery(Class clazz, Map<String, String> map) {
		Session session = sf.getCurrentSession();
		String q = new String("from " + clazz.getName() + " where ");
		String closeWhere = "";
		for (Map.Entry<String, String> m : map.entrySet()) {
			closeWhere += "and ";
			closeWhere += m.getKey() + " = '" + m.getValue() +"'";
		}
	
		q =  q + closeWhere.substring("and ".length());
		Transaction tx = session.beginTransaction();
		List<T> list = (List<T>) session.createQuery(q).list();
		tx.commit();
		//session.close();
		return list;
	}

}
