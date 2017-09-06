package ua.nure.nikonova.bloodbank.model;

import java.util.Date;

import ua.nure.nikonova.bloodbank.dao.PersonDAO;

public class Event {
	String donorLogin, recipientLogin;
	Person donor, recipient;
	Date date;
	String status;
	public String getDonorLogin() {
		return donorLogin;
	}
	public void setDonorLogin(String donorLogin) {
		this.donorLogin = donorLogin;
	}
	public String getRecipientLogin() {
		return recipientLogin;
	}
	public void setRecipientLogin(String recipientLogin) {
		this.recipientLogin = recipientLogin;
	}
	public Person getDonor() {
		return donor;
	}
	public void setDonor(Person donor) {
		this.donor = donor;
	}
	public Person getRecipient() {
		return recipient;
	}
	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Event(String donorLogin, String recipientLogin, Date date, String string) {
		super();
		PersonDAO dao = new PersonDAO();
		this.donorLogin = donorLogin;
		this.recipientLogin = recipientLogin;
		this.donor = dao.getByLogin(donorLogin);
		this.recipient = dao.getByLogin(recipientLogin);
		this.date = date;
		this.status = string;
	}
	@Override
	public String toString() {
		return "Event [donorLogin=" + donorLogin + ", recipientLogin=" + recipientLogin + ", donor=" + donor.getName()
				+ ", recipient=" + recipient.getName() + ", date=" + date + ", status=" + status + "]";
	}
	
	
	
	

}
