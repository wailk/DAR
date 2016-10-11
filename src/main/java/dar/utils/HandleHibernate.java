package dar.utils;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HandleHibernate {
	/** Session opened */
	private static SessionFactory sessionFactory = null;

	/** Service registery */
	private static ServiceRegistry serviceRegistry = null;

	/** Configuration of hibernate */
	private static Configuration configuration;

	public static SessionFactory initSessionFactory(List<Class<?>> ls) {
		try {
			if (sessionFactory == null) {
				configuration = new Configuration();
				// Create Properties, can be read from property files too
				configuration.configure("hibernate.cfg.xml");

				// classes annotee pour les mapping avec les table de la base
				ls.forEach(cl ->{
					System.out.println("annoter class " + cl);
					configuration.addAnnotatedClass(cl);
				});
				serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
						.build();

				System.out.println("Hibernate Java Config serviceRegistry created");

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed :\n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

	/**
	 * configuration par XML
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static SessionFactory getSessionFactory(List<String> listAnnotes) throws ClassNotFoundException {
		if (sessionFactory == null) {
			throw new ExceptionInInitializerError("session factory n'est pas initialise");
		}
		return sessionFactory;
	}

}
