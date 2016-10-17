package dar.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HandleHibernate {
	/** Session opened */
	private static SessionFactory sf = null;

	/** Service registery */
	private static ServiceRegistry sr = null;

	/** Configuration of hibernate */
	private static Configuration cf;

	public static SessionFactory getSF() {
		try {
			if (sf == null) {
				cf = new Configuration().configure("hibernate.cfg.xml");

				StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
				srb.applySettings(cf.getProperties());
				sr = srb.build();
				sf = cf.buildSessionFactory(sr);
			}

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed :\n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sf;
	}

}
