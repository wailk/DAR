package dar.utils;


import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import dar.core.Appartements;
import dar.core.Photos;
import dar.core.Users;



public class Hibernate_tests{
	
	//@Test
	public static void test1(){
		 
        Configuration cf = new Configuration().configure("hibernate.cfg.xml");
 
        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        SessionFactory sf = cf.buildSessionFactory(sr);
 
        Session session = sf.openSession();
 
        Users us1 = new Users();
		us1.setName("Hichri");
		us1.setFirstname("Mootez");
		us1.setEmail("hichri.mootezgmail.com");
 
                Transaction tx = session.beginTransaction();
                session.save(us1);
                tx.commit();
                System.out.println("user saved successfully.....!!");
                session.close();
                sf.close();
        }
	//@Test
	public static void test2(){
		 
        Configuration cf = new Configuration().configure("hibernate.cfg.xml");
 
        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        SessionFactory sf = cf.buildSessionFactory(sr);
 
        Session session = sf.openSession();
 
        Appartements appar = new Appartements();
		appar.setAdresse("81 avenue de la bourdonnais 75007 Paris");;
		
		appar.setLoyer(500);
		appar.setMeuble(true);
		appar.setType("Studio T1");
		appar.setSuperficie(15);
 
                Transaction tx = session.beginTransaction();
                session.save(appar);
                tx.commit();
                System.out.println("appartement saved successfully.....!!");
                session.close();
                sf.close();
        }
	
	//@Test
	public static void test3(){
		 
        Configuration cf = new Configuration().configure("hibernate.cfg.xml");
 
        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        SessionFactory sf = cf.buildSessionFactory(sr);
 
        Session session = sf.openSession();
 
       Photos ph = new Photos();
       
       ph.setChemin("c:_photos_photo.jpg");
                Transaction tx = session.beginTransaction();
                session.save(ph);
                tx.commit();
                System.out.println("photo saved successfully.....!!");
                session.close();
                sf.close();
        }
	public static void main(String[] args){
		test1();
		test2();
		test3();		
		
		
	}
}
		
