package ua.nure.nikonova.bloodbank.model;

public class Admin {

	String login,password;
	double x,y;
	public Admin(String login, String password, double x, double y) {
		super();
		this.login = login;
		this.password = password;
		this.x = x;
		this.y = y;
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
	

}
