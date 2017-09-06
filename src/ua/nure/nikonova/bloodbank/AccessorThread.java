package ua.nure.nikonova.bloodbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import ua.nure.nikonova.bloodbank.dao.PersonDAO;
import ua.nure.nikonova.bloodbank.logic.Finder;
import ua.nure.nikonova.bloodbank.model.Person;
public class AccessorThread implements Runnable {
	public final static String REQ_SEPARATOR=" ";

	private Socket s;
	private DataOutputStream out;	
	private DataInputStream in;
	private String result;

	String res;
	PersonDAO dao;
	public AccessorThread(Socket s) throws IOException {
		this.s = s;
		in = new DataInputStream (s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
		dao = new PersonDAO();
	}

	@Override
	public void run() {
		try {
			while ((result = in.readUTF()) != null) {
				System.out.println(result);
				String[] requestParams = result.split(REQ_SEPARATOR);

				switch (requestParams[0]) {
				case "-get":
					doGet(requestParams); break;
				case "-add":
					doAdd(requestParams); break;

				case "-update":
					doUpdate(requestParams); break;

				case "-getdonors":
					doGetDonors(requestParams); break;

				case "-getrecipients":
					doGetRecipients(requestParams); break;

				case "-delete":
					doDelete(requestParams); break;	

				case "-getall":
					doGetAll(); break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				s.close();
				out.close();
				in.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}



	private void doGetAll() {
		List<Person> persons = dao.getAll();
		if (persons==null) {
			res = "No users here";
		}
		else {
			StringBuffer sb = new StringBuffer();
			for(Person p:persons) {sb.append(p).append("\n");}
			res = sb.toString();
		}
		System.out.println( "#BLLAccessor(-getbylogin): " + res);
		addToOutput(res);	

	}

	private void doDelete(String[] requestParams) {
		try {
			String login = requestParams[1];

			if (dao.delete(login)) {
				res = "Deleted person: "+login;
			}
			else {
				res = "Cannot delete person: "+login;
			}

		}
		catch (Exception e) {
			res = "Error while parsing parameters: "+e;
		}
		addToOutput(res);

	}

	private void doGetDonors(String[] requestParams) {
		boolean doFilter=false;
		if(requestParams.length>=4 && requestParams[2].equals("-maxdistance")) {
			doFilter = true;
		}
		try {
			String login = requestParams[1];

			Person p = dao.getByLogin(login);
			if(p==null) {
				res = "No person with login:"+login;				
			}
			else {
				Finder df = new Finder(p);
				List<Person> results = df.findDonors();
				
				if (results!=null) {
					if(doFilter) {
						int maxDistance = Integer.parseInt(requestParams[3]);
						results = df.filterByDistance(results, maxDistance);
					}
					StringBuilder donors = new StringBuilder();
					for (Person pRes:results) {
						donors.append(pRes.toString());
					}
					res = donors.toString();
				}
			}

		}
		catch (Exception e) {
			res = "Error while parsing parameters: "+e;
		}
		addToOutput(res);


	}


	private void doGetRecipients(String[] requestParams) {
		boolean doFilter=false;		
		if(requestParams.length>=4 && requestParams[2].equals("-maxdistance")) {
			doFilter = true;
		}
			try {
				String login = requestParams[1];
				Person p = dao.getByLogin(login);
				if(p==null) {
					res = "No person with login:"+login;				
				}
				else {
					Finder df = new Finder(p);
					List<Person> results = df.findRecipients();
					
					if (results!=null) {
						if(doFilter) {
							int maxDistance = Integer.parseInt(requestParams[3]);
							results = df.filterByDistance(results, maxDistance);
						}
						StringBuilder sb = new StringBuilder();
						for (Person pRes:results) {
							sb.append(pRes.toString());
						}
						res = sb.toString();
					}
				}
			}
			catch (Exception e) {
				res = "Error while parsing parameters: "+e;
			}
			
			addToOutput(res);


		}

		private void doUpdate(String[] requestParams) {
			try {
				String oldLogin = requestParams[1];
				Person p = new Person (requestParams[2], requestParams[3], requestParams[4],
						Double.parseDouble(requestParams[5]), Double.parseDouble(requestParams[6]),
						requestParams[7],requestParams[8],
						Integer.parseInt(requestParams[9]), Integer.parseInt(requestParams[10]));
				if (dao.update(oldLogin,p)) {
					res = "Updated person: "+p.toString();
				}
				else {
					res = "Cannot update person: "+p.toString();
				}

			}
			catch (Exception e) {
				res = "Error while parsing parameters: "+e;
			}
			addToOutput(res);

		}

		private void doAdd(String[] resultNodes) {
			try {

				Person p = new Person (resultNodes[1], resultNodes[2], resultNodes[3],
						Double.parseDouble(resultNodes[4]), Double.parseDouble(resultNodes[5]),
						resultNodes[6],resultNodes[7],
						Integer.parseInt(resultNodes[8]), Integer.parseInt(resultNodes[9]));
				if (dao.add(p)) {
					res = "Added person: "+p.toString();
				}
				else {
					res = "Cannot add person: "+p.toString();
				}

			}
			catch (Exception e) {
				res = "Error while parsing parameters: "+e;
			}
			addToOutput(res);

		}

		private void doGet(String[]resultNodes) {
			Person person = dao.getByLogin(resultNodes[1]);
			if (person==null) {
				res = "Not found person with login: "+resultNodes[1];
			}
			else {res = person.toString();}
			System.out.println( "#BLLAccessor(-getbylogin): " + res);
			addToOutput(res);	

		}



		private void addToOutput(String data) {
			try {
				out.writeUTF(data);
				out.flush();}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}


