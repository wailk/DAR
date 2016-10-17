package dar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CrudDao<T> {

	private SessionFactory sf;

	public CrudDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public T getElement(Class clazz, int id) {
		T elem;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(">>>>>>" + getClass());
		elem = (T) session.get(clazz, id);
		tx.commit();
		session.close();
		return elem;
	}

	public void removeElement(T objet) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(objet);
		tx.commit();
		session.close();
	}

	public List<T> getAll() {
		return null;
	}

	public void save(T elem) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(elem);
		tx.commit();
		session.close();
	}

}
