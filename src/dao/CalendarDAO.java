package dao;

import java.util.ArrayList;
import java.util.List;

import hibernateUtil.HibernateUtil;
import model.CalendarDTO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class CalendarDAO {

	
	
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
		
		
		
		//// TORNA TUTTI GLI EVENTI
		public List<CalendarDTO> getTuttiGliEventi(){
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;
			
			List<CalendarDTO> eventi = new ArrayList<CalendarDTO>();

			try{
				tx=session.getTransaction();
				tx.begin();
				
				Query query=session.createQuery("from CalendarDTO");
				
				eventi = (List<CalendarDTO>)query.list();
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return eventi;
			
		}
		
           
		
		
		/// LEGGI DA ID
		public CalendarDTO leggiEventoDaId(long id){
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;
			
			CalendarDTO c = null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				c = session.get(CalendarDTO.class, id);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return c;
			
		}
		
		
		
		/// MODIFICA
		public void aggiornaEvento(CalendarDTO c){
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				session.update(c);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
		}
		
		
		
		/// ELIMINA
		public void eliminaEvento(CalendarDTO c){
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				session.delete(c);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
		}
		
		
}
