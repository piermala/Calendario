package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalendarDTO implements Serializable {

	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    public String id;
		
	    public String title;
	    public String start;
	    public String end;
	    public String color;
	    
	    
	    
	    public String getColor() {
	        return color;
	    }
	    public void setColor(String color) {
	        this.color = color;
	    }
	
	    
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getStart() {
	        return start;
	    }
	    public void setStart(String start) {
	        this.start = start;
	    }
	    public String getEnd() {
	        return end;
	    }
	    public void setEnd(String end) {
	        this.end = end;
	    }
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
}