package prova;

import dao.CalendarDAO;
import model.CalendarDTO;

public class MainProva {

	public static void main(String[] args) {
	
		CalendarDTO c = new CalendarDTO();
		c.setStart("2016-12-20");
		c.setEnd("2016-12-30");
		c.setTitle("aaaa");
		
		
		CalendarDAO cDao = new CalendarDAO();
		cDao.aggiungiEvento(c);
		
		
		
		
		
	}
	
}
