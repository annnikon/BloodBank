package ua.nure.nikonova.bloodbank.dao;

import ua.nure.nikonova.bloodbank.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySqlConnector {

	private static final String url = "jdbc:mysql://localhost:3306/bloodbank?autoReconnect=true&useSSL=false";
	private static final String user = "root";
	private static final String password = "1234";
	private static final String driverName = "com.mysql.jdbc.Driver";

	// JDBC variables for opening and managing connection
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	public static Person getPersonByLogin(String login) {
		String query = "select * from person where login= '" + login + "'";
		Person person = null;
		connect();
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				person = new Person(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();

		}
		destroy();
		return person;

	}

	public static void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void destroy() {
		try {
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Person> selectPerson(String query) {
		List<Person> list = new ArrayList<Person>();
		connect();
		try {

			rs = stmt.executeQuery(query);
			if (rs == null)
				return null;
			while (rs.next() && rs!=null) {
				Person person = new Person(rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10));
				list.add(person);
			}

		} catch (SQLException sqlEx) {
			System.out.println("error in connection");
			sqlEx.printStackTrace();

		}


		return list;

	}
	
	public static int getMaxId() {
		int result = 0;
		String query = "SELECT max(id) from person;";
		connect();
		try {

			rs = stmt.executeQuery(query);
			if (rs == null)
				return 0;
			if(rs.next()) result = rs.getInt(1);
			

		} catch (SQLException sqlEx) {
			System.out.println("error in connection");
			sqlEx.printStackTrace();

		}

		destroy();
		return result;

	}


	public static List<Person> selectAllPersons() {

		return selectPerson("select * from bloodbank.person;");

	}

	public static boolean addPerson(Person p) {
		boolean ok = false;
		
		String query = String.format(
				"insert into person (name, login, password, x, y, phone, role, bloodgroup, resus)"
				+ " values ('%s','%s','%s','%s','%s','%s','%s','%s','%s');",
				p.getName(), p.getLogin(), p.getPassword(), p.getX(), p.getY(), p.getPhone(), p.getRole(),
				p.getBloodgroup(), p.getResus());
		connect();
		try {

			stmt.executeUpdate(query);
			ok = true;
		} catch (SQLException sqlEx) {

			sqlEx.printStackTrace();

		}
		
		return ok;

	}

	public static boolean updatePerson(String oldLogin, Person p) {
		boolean ok = false;
		String query = String.format(
				"update person set name='%s', login = '%s', password='%s'," + " x='%s', y='%s', phone='%s', role='%s',"
						+ " bloodGroup='%s', resus='%s' where login='%s'",
				p.getName(), p.getLogin(), p.getPassword(), p.getX(), p.getY(), p.getPhone(), p.getRole(),
				p.getBloodgroup(), p.getResus(), oldLogin);
		connect();
		try {

			stmt.executeUpdate(query);
			ok = true;
		} catch (SQLException sqlEx) {

			sqlEx.printStackTrace();

		}
		
		return ok;

	}

	public static boolean removePerson(String login) {
		boolean ok = false;

		String query = "delete from person where login= '" + login + "';";
		connect();
		try {

			stmt.executeUpdate(query);
			ok = true;
		} catch (SQLException sqlEx) {

			sqlEx.printStackTrace();

		}
		
		return ok;

	}
	
	public static Admin selectAdminByLogin(String login) {
		Admin a = null;
		connect();
		try {

			rs = stmt.executeQuery("select * from admin where login='"+login+"';");
			if (rs == null)
				return null;
			if (rs.next()) {
				a = new Admin(rs.getString(2),rs.getString(3),
						rs.getDouble(4), rs.getDouble(5));
				
			}

		} catch (SQLException sqlEx) {
			System.out.println("error in connection");
			sqlEx.printStackTrace();

		}

		
		return a;
	}
		
		

	public static List<Admin> selectAllAdmins() {
		return selectAdmin("select * from admin");
		
	}
	public static List<Admin> selectAdmin(String query) {
		List<Admin> list = new ArrayList<Admin>();
		connect();
		try {

			rs = stmt.executeQuery(query);
			if (rs == null)
				return null;
			while (rs.next()) {
				Admin a = new Admin(rs.getString(2),rs.getString(3),
						rs.getDouble(4), rs.getDouble(5));
				list.add(a);
			}
			if (stmt != null) { stmt.close(); }

			return list;

		} catch (SQLException sqlEx) {
			System.out.println("error in connection");
			sqlEx.printStackTrace();

		}
	 
	  return list;

		
	}

	public static Event selectDonorEvent(Person p) {
	Event e=null;
		connect();
		    try {
		       
		    	 stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                   ResultSet.CONCUR_UPDATABLE);
		      rs = stmt.executeQuery("select * from event where donorLogin='"+p.getLogin()+"'");
		        	if(rs==null) return null;
		      if (rs.next()) {
		        	e = new Event(rs.getString(2),rs.getString(3),
							rs.getDate(4), rs.getString(5));
				
		        }

		    } catch (SQLException ex ) {
		       ex.printStackTrace();
		    }
		    destroy();
			return e;
			
	}
	
	
	
	public static Event selectRecipientEvent(Person p) {
		Event e=null;
		connect();
		    try {
		       
		    	 stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                   ResultSet.CONCUR_UPDATABLE);
		      rs = stmt.executeQuery("select * from event where recipientLogin='"+p.getLogin()+"'");
		        	if(rs==null) return null;
		      if (rs.next()) {
		        	e = new Event(rs.getString(2),rs.getString(3),
							rs.getDate(4), rs.getString(5));
				
		        }

		    } catch (SQLException ex ) {
		       ex.printStackTrace();
		    }
		    destroy();
			return e;
	}
			
	
}