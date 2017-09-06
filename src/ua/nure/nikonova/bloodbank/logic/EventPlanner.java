package ua.nure.nikonova.bloodbank.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.nure.nikonova.bloodbank.dao.PersonDAO;
import ua.nure.nikonova.bloodbank.model.Event;
import ua.nure.nikonova.bloodbank.model.Person;

public class EventPlanner {
public static int MIN_INTERVAL = 30;
public static int MONTH_COUNT = 6;
	
	
	
	Date lastDate, goodDate;
	List <Date> futureDates;
	public EventPlanner(Event event) {
		
		if (event==null) this.lastDate=null;
		else {this.lastDate=event.getDate();			}	
		futureDates=new ArrayList<Date> ();
		findDates();
		
		
	}
	

	
	public List<Date> getfutereDates() {
		return futureDates;
		
	}
	
	
	void findDates() {
		Calendar c = Calendar.getInstance(); 
		if (lastDate==null)  {
			goodDate = new Date();
			
		}
		else {
									
			c.setTime(lastDate); 
			c.add(Calendar.DATE, MIN_INTERVAL);
			goodDate = c.getTime();
			
		}
		futureDates.add(goodDate);
		c.setTime(goodDate);
		for (int i=0; i<MONTH_COUNT; i++) {
			c.add(Calendar.DATE, MIN_INTERVAL);
			futureDates.add(c.getTime());
			
		}
		
		
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Date d:futureDates) {
			sb.append(d.toGMTString()).append(";");
		}
		return sb.toString();
	}
	
	
	

}
