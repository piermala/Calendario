package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalendarDTO;

import com.google.gson.Gson;

import dao.CalendarDAO;

/**
 * Servlet implementation class ServletEvent
 */
@WebServlet("/ServletEvent")
public class ServletEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    private int id;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  List<CalendarDTO> l = new ArrayList<CalendarDTO>();
		 
//		 CalendarDTO c = new CalendarDTO();
//		 c.setId("1");
//		 c.setStart("2016-12-28");
//		 c.setEnd("2016-12-29");
//		 c.setTitle("Task in Progress");
//		
//		 CalendarDTO d = new CalendarDTO();
//		 d.setId("2");
//		 d.setStart("2016-12-30");
//		 d.setEnd("2016-12-31");
//		 d.setTitle("Task in Progress");
//		 
//		 l.add(c);
//		 l.add(d);
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
		 out.write(new Gson().toJson(l));
	
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		        String title=req.getParameter("title");
		        String start=req.getParameter("start");
		        
		       // converto mili secondi to yyyy-mm-dd
		        Date fine= new Date(Long.parseLong(start));
		        Date inizio= new Date(Long.parseLong(start));

		      //  id++;
		        
		        CalendarDTO c=new CalendarDTO();
		         c.setEnd(fine.toString());
		         c.setStart(inizio.toString());
		         c.setTitle(title);
		         c.setColor("");
		        // c.setId(String.valueOf(id)); 
		         
	            
		       //  l.add(c);
		        
		       //  PrintWriter out = resp.getWriter();
				// out.write("3");
				 
				// System.out.println(jsonFeedback);
			  
		         
		         
		         /// qui salviamo nel database
				  CalendarDAO cDao = new CalendarDAO();
				  cDao.aggiungiEvento(c);

		
		
	}
	
	
	
	
	
	


}
