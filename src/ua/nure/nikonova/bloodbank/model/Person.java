package ua.nure.nikonova.bloodbank.model;

import com.google.gson.Gson;

public class Person {
	int id;
	String name, login, password;
	double x,y;
	String phone, role;
	int bloodgroup;
	int resus;
	public Person(String name, String login, String password, 
			double x, double y, 
			String phone, String role,
			int bloodgroup, int resus) {
	
		this.name = name;
		this.login = login;
		this.password = password;
		this.x = x;
		this.y = y;
		this.phone = phone;
		this.role = role;
		this.bloodgroup = bloodgroup;
		this.resus = resus;
	}
	
public String toJson() {
	Gson gson = new Gson();
	
	String jsonInString = gson.toJson(this);
	return jsonInString;
}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(int bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getResus() {
		return resus;
	}
	public void setResus(int resus) {
		this.resus = resus;
	}
	
	public String getBloodInfo() {
		StringBuilder res = new StringBuilder();
		switch(bloodgroup) {
		case 1: res.append("I (0)");break;
		case 2: res.append("II (A)");break;
		case 3: res.append("III (B)");break;
		case 4: res.append("IV (AB)");break;
		}
		switch(resus) {
		case 0: res.append(" Rh -"); break;
		case 1: res.append(" Rh +"); break;
		}
		return res.toString();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", login=" + login + ", password=" + password + ", x=" + x
				+ ", y=" + y + ", phone=" + phone + ", role=" + role + ", bloodgroup=" + bloodgroup + ", resus=" + resus
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!obj.getClass().equals(Person.class)) return false;
		Person p = (Person) obj;
		return p.getLogin().equals(login);
				
	}
	
	
	
	
	
	

}
