package ua.nure.nikonova.bloodbank.logic;
import java.util.ArrayList;
import java.util.List;

import ua.nure.nikonova.bloodbank.dao.MySqlConnector;
import ua.nure.nikonova.bloodbank.model.BloodGroups;
import ua.nure.nikonova.bloodbank.model.Person;

public class Finder {
	public static double MAX_RADIUS = 30;
	
	Person user;
	BloodGroups userBloodGroup;
	boolean hasRh;
	
	public Finder(Person recipient) {
		this.user=recipient;
		
		switch (recipient.getBloodgroup()) {
		case 1: userBloodGroup=BloodGroups.FIRST; break;
		case 2: userBloodGroup=BloodGroups.SECOND; break;
		case 3: userBloodGroup=BloodGroups.THIRD; break;
		case 4: userBloodGroup=BloodGroups.FORTH; break;
		default: throw new IllegalArgumentException("Wrong blood number");
		}
		
		this.hasRh=(recipient.getResus()==1)?true:false;
		 
		
	}
	
	public double distance(double x2, double y2) {
		double x1=user.getX();
		double y1=user.getY();
		return  Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	
	public List<Person> findDonors() {		
		List<Person>donours = new ArrayList<Person>();
		for(BloodGroups group : userBloodGroup.getDonours()) {
			StringBuilder sb = new StringBuilder("SELECT * FROM person WHERE bloodgroup=");
		sb.append(group.getBloodCode());
		sb.append(" AND role='donor' ");
		if (!hasRh) {
			sb.append(" AND resus=0 ");
		}
		sb.append(";");
		donours.addAll(MySqlConnector.selectPerson(sb.toString()));
		}
		donours.remove(user); //recipient cannot be a donor for himself
		return donours;
	}
	
	public List<Person> findRecipients() {		
		List<Person>recipients = new ArrayList<Person>();
		for(BloodGroups group : userBloodGroup.getRecipients()) {
			StringBuilder sb = new StringBuilder("SELECT * FROM person WHERE bloodgroup=");
		sb.append(group.getBloodCode());
		sb.append(" AND role='recipient' ");
		if (hasRh) {
			sb.append(" AND resus=1 ");
		}
		sb.append(";");
		recipients.addAll(MySqlConnector.selectPerson(sb.toString()));
		}
		recipients.remove(user); //user cannot be a recipient for himself
		return recipients;
	}
	
	public List<Person> filterByDistance(List<Person> data, int maxDistance) {
		List<Person> result = new ArrayList<Person>() ;
		if (data!=null) 
		{
			for(Person p: data) {
				if(distance(p.getX(),p.getY())<=maxDistance) {
					result.add(p);
				}
			}
		}
		return result;
		
		
	}
	
	
	

}
