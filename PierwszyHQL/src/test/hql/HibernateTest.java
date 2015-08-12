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
		Samochod samochod = new Samochod();
		Serwis serwis = new Serwis();
		
		serwis.setNazwaSamochodu("Skoda");
		serwis.setPrzebieg(50000.00);
		serwis.setDokonalPrzegladu("Artur");
		
		dane.setUserName("Pawe³");
	
		samochod.setNazwaSamochodu("Sedan");
		samochod.setPrzebieg(10000.39);
		
		dane.setSamochod(samochod);
		
		//Przygotowanie Hibernata
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		session.beginTransaction();
		
		int minimalnyUser = 1;
		
		 //select i where
		//Query query = session.createQuery("select s.userName  from UzytkownikDane s where userID >"+minimalnyUser);
		//Query query = session.createQuery("select nazwaSamochody,przebieg from Samochod ");
		//Query query = session.getNamedQuery("Uzytkownicy");
		//Query query = session.createQuery("from UzytkownikDane ");
		//Query query = session.getNamedQuery("Samochody");
		//Query query = session.getNamedQuery("Przebieg");
		//Query query = session.createQuery("from UzytkownikDane as userName");
		
		// order by
		//Query query = session.createQuery("select userName from UzytkownikDane order by userName.userName  ");
		//Query query = session.createQuery("select nazwaSamochody from Samochod order by nazwaSamochody.nazwaSamochody");
		
		// Update
		//Query query = session.createQuery("update UzytkownikDane set userName=:newNAme where userName=:userName");
		//query.setString("userName", "Mateusz");
		//query.setString("newNAme", "zmian");
		// query.executeUpdate();
		
		//usuwanie
		//Query query = session.createQuery("delete UzytkownikDane where userName=:userName");
		//query.setString("userName", "Robert");
		//query.executeUpdate();

		// joiny
		//Query query = session.createQuery("select u.userName,s.nazwaSamochody,s.przebieg from UzytkownikDane u  right join u.samochod s");
		//Query query = session.createQuery("select s.nazwaSamochody,u.userName from Samochod s "+ "left join s.dane u");
		//Query query = session.createQuery("select s.nazwaSamochody,s.przebieg,u.userName from Samochod s "+ "full join s.dane u");
		//Query query = session.createQuery("select u.userName,s.nazwaSamochody from UzytkownikDane u " + " inner join u.samochod s");
		//Query query = session.createQuery("select u.userName,s.nazwaSamochody from UzytkownikDane u " + " join u.samochod s");
		//Query query = session.createQuery("select u.userName,s.nazwaSamochody,s.przebieg from UzytkownikDane u JOIN u.samochod s");
	    //Query query = session.createQuery("select u.nazwaSamochody ,u.przebieg, s.przebieg,s.dokonalPrzegladu from Samochod u join u.serwiss s");
		
		//List<Object[]> doZapisuJoinow = query.list();
		//List<UzytkownikDane> uzyDane = (List<UzytkownikDane>) query.list();
		//List<Double> zapisDoListyDouble = (List<Double>) query.list();
		//List<String> zapisDoListyString = (List<String>) query.list();
		
		session.save(dane);
		session.save(samochod);
		session.save(serwis);
		session.getTransaction().commit();
		
		session.close();
		sessionfactory.close();
		
		//for(Object[] j :doZapisuJoinow)
		//System.out.println(Arrays.toString(j) );
		
		//for(String u : zapisDoListyString)
		//System.out.println("Uzytkownicy: " +u);
		
		//for(Double u : zapisDoListyDouble)
		//System.out.println("Uzytkownicy: " +u);
		
		//for(UzytkownikDane d : uzyDane)
		//System.out.println("Uzytkownicy : " + d.getUserName());
	}
}
