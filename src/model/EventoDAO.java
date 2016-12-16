package model;

import hibernateUtil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import servlet.CalendarDTO;

public class EventoDAO {

	
	/// AGGIUNGI
	public void aggiungiEvento(CalendarDTO c){
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(c);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
	}
	
	
	
	/// LEGGI DA ID
	public void leggiEventoDaId(long id){
		
	}
	
	
	
	/// MODIFICA
	public void aggiornaEvento(CalendarDTO c){
		
	}
	
	
	
	/// ELIMINA
	public void eliminaEvento(CalendarDTO c){
		
	}
	
	
	
	
	
	
	
}
