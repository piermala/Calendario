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
@WebServlet("/UdateDeleteServletEvent")
public class UdateDeleteServletEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CalendarDAO cDao = new CalendarDAO();
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String idEvento=request.getParameter("idEvento");
		  
		  //qui cancelliamo l'evento dal database
	        System.out.println("id evento="+idEvento );

	        long id = Long.parseLong(idEvento);	        
	        CalendarDTO c = cDao.leggiEventoDaId(id);
	        
	        cDao.eliminaEvento(c);
	        
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			
			

		 	String title=req.getParameter("title");
	        String start=req.getParameter("start");
	        String idEvento=req.getParameter("idEvento");
	        Date fine= new Date(Long.parseLong(start));
	        System.out.println("id evento="+idEvento+" titolo nuovo="+title );
	            
	        long id = Long.parseLong(idEvento);
	        
	        CalendarDTO c = cDao.leggiEventoDaId(id);
	        
	        c.setTitle(title);
	        c.setStart(fine.toString());
	        c.setEnd(fine.toString());
	        
	        cDao.aggiornaEvento(c);
	        
	        //1- prima prendere l' evento con questo idEvento dal DB
	        //2- settare i nuovi valori (title,start,fine) 
	        // 3- chiamare un metodo agiiornaEvento dentro DB
	}
	
	
	
	
	


}
