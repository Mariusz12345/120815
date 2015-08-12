package test.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		UzytkownikDane dane = new UzytkownikDane();
		dane.setUserName("Piotr");
		
		Samochod samochod = new Samochod();
		samochod.setNazwaSamochodu("Honda");
		samochod.setPrzebieg(15.00);
		dane.setSamochod(samochod);
		
		//Przygotowanie Hibernata
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		session.beginTransaction();
		
		int minimalnyUser = 1;
		
		 //select i where
		//Query query = session.createQuery("select userName from UzytkownikDane where userID >"+minimalnyUser);
		//Query query = session.createQuery("select nazwaSamochodu from Samochod ");
		//Query query = session.getNamedQuery("Uzytkownicy");
		//Query query = session.createQuery("from UzytkownikDane ");
		//Query query = session.getNamedQuery("Samochody");
		 //Query query = session.getNamedQuery("Przebieg");
		//Query query = session.createQuery("from UzytkownikDane as userName");
		
		// order by
		//Query query = session.createQuery("select userName from UzytkownikDane order by userName.userName  ");
		
		// Update
		//Query query = session.createQuery("update UzytkownikDane set userName=:newNAme where userName=:userName");
		//query.setString("userName", "jacek");
		//query.setString("newNAme", "zmian");
		 //squery.executeUpdate();
		
		//usuwanie
		//Query query = session.createQuery("delete UzytkownikDane where userName=:userName");
		//query.setString("userName", "Joana");
		//query.executeUpdate();

		// joiny
		//Query query = session.createQuery("select u.userName,s.nazwaSamochody from UzytkownikDane u "+" join u.samochod s");
	
		//List<Object[]> list = query.list();
		//List<UzytkownikDane> uzyDane = (List<UzytkownikDane>) query.list();
		//List<Double> zapisDoListyDouble = (List<Double>) query.list();
		//List<String> zapisDoListyString = (List<String>) query.list();
		
		session.save(dane);
		session.save(samochod);
		session.getTransaction().commit();
		
		session.close();
		sessionfactory.close();
		
		//for(Object[] j:list){
			//System.out.println(Arrays.toString(j) + j);
		//}
			
		//for(String u : zapisDoListyString)
		//System.out.println("Uzytkownicy: " +u);
		
		//for(Double u : zapisDoListyDouble)
		//System.out.println("Uzytkownicy: " +u);
		
		//for(UzytkownikDane d : uzyDane)
		//System.out.println("Uzytkownicy : " + d.getUserName());
	}
}
