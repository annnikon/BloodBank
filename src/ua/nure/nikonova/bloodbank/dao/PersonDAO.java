package ua.nure.nikonova.bloodbank.dao;
import java.util.List;

import ua.nure.nikonova.bloodbank.logic.EventPlanner;
import ua.nure.nikonova.bloodbank.logic.Finder;
import ua.nure.nikonova.bloodbank.model.Event;
import ua.nure.nikonova.bloodbank.model.Person;

public class PersonDAO {
	public boolean add(Person p) {
		return MySqlConnector.addPerson(p);
		
	}
	
	public int getLastId() {
		return MySqlConnector.getMaxId();
	}
	
	public boolean delete(String login) {
		return MySqlConnector.removePerson(login);
		
	}
	
	public boolean update(String oldLogin,Person p) {
		return MySqlConnector.updatePerson(oldLogin,p);
	}
	
	public Event getDonorEvent(Person p) {
		return MySqlConnector.selectDonorEvent(p);
	}
	
	public Event getRecipientEvent(Person p) {
		return MySqlConnector.selectRecipientEvent(p);
	}
	
	public List<Person> getAllDonors() {
		return MySqlConnector.selectPerson("select * from person where role='donor'");
	}
	
	public List<Person> getAllRecipients() {
		return MySqlConnector.selectPerson("select * from person where role='recipient'");
	}
	
	public List<Person> getAll() {
		return MySqlConnector.selectAllPersons();
	}
	
	public Person getByLogin(String login) {
		return MySqlConnector.getPersonByLogin(login);
	}
	
	public List<Person> getDonors(Person p) {
		Finder df = new Finder(p);
		return df.findDonors();
	}
	
	public List<Person> getRecipients(Person p) {
		Finder df = new Finder(p);
		return df.findRecipients();
	}

	public Event getEvent(Person p) {
	if(p==null) return null;
	if(p.getRole().equals("donor")) {
		return getDonorEvent(p);
	}
	if(p.getRole().equals("recipient")) {
		return getRecipientEvent(p);
	}
	else return null;
	}
	
	
	
	
	

	
	
}
