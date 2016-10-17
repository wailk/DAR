//package dar.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.Test;
//
//import dar.core.Users;
//import dar.utils.HibernateUtil;
//
//public class HibernateMain {
//
//	@Test
//	public static void main(String[] args) {
//		Users us1 = new Users();
//		us1.setName("Hichri");
//		us1.setFirstname("Mootez");
//		us1.setEmail("hichri.mootezgmail.com");
//		
//		//Get Session
//		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		//Get Session
//		//SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
//		Session session = sessionFactory.getCurrentSession();
//		//start transaction
//		session.beginTransaction();
//		//Save the Model object
//		session.save(us1);
//		//Commit transaction
//		session.getTransaction().commit();
//		System.out.println("Employee ID="+us1.getId_user());
//		
//		//terminate session factory, otherwise program won't end
//		sessionFactory.close();
//	}
//	}
//
//
