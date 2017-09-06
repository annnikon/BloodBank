package ua.nure.nikonova.bloodbank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ua.nure.nikonova.bloodbank.dao.PersonDAO;
import ua.nure.nikonova.bloodbank.logic.EventPlanner;
import ua.nure.nikonova.bloodbank.model.Person;

@RestController
public class LoginController {
	
	
	public LoginController() {
		super();
		
		
	}
	
	public void makeCalendar() {
		 java.util.Calendar theCal = java.util.Calendar.getInstance();
		  int currentYearInt  = theCal.get(java.util.Calendar.YEAR);
		  int currentMonthInt = theCal.get(java.util.Calendar.MONTH);
		  int currentDayInt   = theCal.get(java.util.Calendar.DATE);
		  String currentYearString  = new Integer(currentYearInt).toString();
		  String currentMonthString = new Integer(currentMonthInt).toString();

		

		  // determine the next/previous month and year
		  int intMonth = new Integer(currentMonthString).intValue();
		  int intYear  = new Integer(currentYearString).intValue();

		  // determine the name of the current intMonth
		  String monthNames[] = {"January",
		                         "February",
		                         "March",
		                         "April",
		                         "May",
		                         "June",
		                         "July",
		                         "August",
		                         "September",
		                         "October",
		                         "November",
		                         "December" };

		  String monthName = monthNames[intMonth];

		 
	}
	
	public void remakeCalendar(String newMonth, String newYear) {
		 java.util.Calendar theCal = java.util.Calendar.getInstance();
		  int currentYearInt  = theCal.get(java.util.Calendar.YEAR);
		  int currentMonthInt = theCal.get(java.util.Calendar.MONTH);
		  int currentDayInt   = theCal.get(java.util.Calendar.DATE);
		  String currentYearString  = new Integer(currentYearInt).toString();
		  String currentMonthString = new Integer(currentMonthInt).toString();

		 

		  // reset the month and year if necessary
		  if ( newMonth != null )
		  {
		    currentMonthString = newMonth;
		  }
		  if ( newYear != null )
		  {
		    currentYearString = newYear;
		  }

		  // determine the next/previous month and year
		  int intMonth = new Integer(currentMonthString).intValue();
		  int intYear  = new Integer(currentYearString).intValue();

		  // determine the name of the current intMonth
		  String monthNames[] = {"January",
		                         "February",
		                         "March",
		                         "April",
		                         "May",
		                         "June",
		                         "July",
		                         "August",
		                         "September",
		                         "October",
		                         "November",
		                         "December" };

		  String monthName = monthNames[intMonth];

		  // determine the next/previous month and year.
		  // this is really only needed by calendar.jsp, but i moved it here
		  // to simplify calendar.jsp.
		  int nextYear = intYear;
		  int prevYear = intYear;
		  int prevMonth = intMonth-1;
		  if ( prevMonth==-1 )
		  {
		    prevMonth=11;
		    prevYear--;
		  }
		  int nextMonth = intMonth+1;
		  if ( nextMonth==12 )
		  {
		    nextMonth = 0;
		    nextYear++;
		  }

	}
	
	
	
	
	@RequestMapping("/{role}/logout")
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");	
		model.addObject("error","You were logged out");
		return model;
	}

	
	@RequestMapping(value = "/{role}/login", method = RequestMethod.POST)
	public ModelAndView check(@RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam(value="newMonth", required=false) String newMonth,
            @RequestParam(value="newYear", required=false) String newYear,
            @PathVariable("role") String role) {
		ModelAndView model = new ModelAndView();
		PersonDAO dao=new PersonDAO();
		Person person = dao.getByLogin(login);
		if (person==null) {
			model.setViewName("hello");
			model.addObject("error", "No user with login "+login+ ". You can register now.");
		}
		
		
		else if (!person.getPassword().equals(password)) {
				model.setViewName("hello");
				model.addObject("error", "Wrong password. Try again.");
			}
			else {
				
			
		model.setViewName(role+"Profile");
		model.addObject("user", person);
		model.addObject("donors",dao.getDonors(person));
		model.addObject("recipients",dao.getRecipients(person));
		model.addObject("event", dao.getEvent(person));
		EventPlanner planner = new EventPlanner(dao.getEvent(person));
		model.addObject("dates", planner.getfutereDates());
		
		if(newYear!=null && newMonth!=null) remakeCalendar(newMonth,newYear);
	
	
		}
		
		return model;
	}
	

	@RequestMapping(value = "/{role}/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("login") String login,
			@RequestParam("login") String name,
            @RequestParam("password") String password,
            @RequestParam("login") String cpassword, 
            @RequestParam("phone") String phone,
            @PathVariable("role") String role,
            @RequestParam("x") String x,
            @RequestParam("y") String y,
            @RequestParam("bloodgroup") String bloodgroup,
            @RequestParam("resus") String resus) {
		ModelAndView model = new ModelAndView();
		PersonDAO dao=new PersonDAO();
		Person person = dao.getByLogin(login);
		if (person!=null) {
			model.setViewName("hello");
			model.addObject("error", "User with login "+login+ "already exists");
		}
		
		else{
			
			Person newPerson = new Person(name,login,password,Double.parseDouble(x),Double.parseDouble(y),phone,role,
					Integer.parseInt(bloodgroup),Integer.parseInt(resus));
			if (!dao.add(newPerson)) {
				model.setViewName("hello");
				model.addObject("error", "Cannot add this user to database. Try again.");
			}
			else {
			
		model.setViewName(role+"Profile");
		model.addObject("user", newPerson);
		model.addObject("donors",dao.getDonors(newPerson));
		model.addObject("recipients",dao.getRecipients(newPerson));
		EventPlanner planner = new EventPlanner(dao.getEvent(newPerson));
		model.addObject("dates", planner.getfutereDates());

			}
			}
		
		return model;
	}
	
	@RequestMapping(value="/{role}/contact/{userLogin}")
	public ModelAndView contact(@PathVariable("login") String userLogin,   @PathVariable("role") String role) {
		ModelAndView model = new ModelAndView();
		PersonDAO personDAO=new PersonDAO();
		Person to=personDAO.getByLogin(userLogin);
		model.setViewName("result");
		if (to==null) {
			
			model.addObject("error", "No person with login "+userLogin);
		}
		
		else {
			String phone = to.getPhone();
			String text = "Hello, "+to.getName()+". I am your "+role+".I am waiting for donation.";
			MessageSender ms = new MessageSender(phone,text);
			try {
				ms.send();
				model.addObject("error", "Message sent!");
			}
			catch(Exception e) {
				model.addObject("error", "Cannot send message: "+e.getMessage());
			}
			
		
		}
		return model;
	}
	
	
	
	@RequestMapping(value = "/{role}/edit", method = RequestMethod.POST)
	public ModelAndView edit(@RequestParam("login") String login,
			@RequestParam("oldLogin") String oldLogin,
			@RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword, 
            @RequestParam("phone") String phone,
            @PathVariable("role") String role,
            @RequestParam("x") String x,
            @RequestParam("y") String y,
            @RequestParam("bloodgroup") String bloodgroup,
            @RequestParam("resus") String resus) {
		
		ModelAndView model = new ModelAndView();
		PersonDAO dao=new PersonDAO();
		
		Person person = dao.getByLogin(oldLogin);
		if (person!=null && !oldLogin.equals(login)) {
			model.setViewName(role+"Profile");
			model.addObject("error", "This login '"+login+ "' already exists");
		}
		
		else{
			
			Person editedPerson = new Person(name,login,password,Double.parseDouble(x),Double.parseDouble(y),phone,role,
					Integer.parseInt(bloodgroup),Integer.parseInt(resus));
			if (!dao.update(oldLogin,editedPerson)) {
				model.setViewName(role+"Profile");
				model.addObject("error", "Cannot update your info."); 
			}
			else {
			
		model.setViewName(role+"Profile");
		model.addObject("error", "Updated suceesfully. Click 'Close' to return. "); 
		model.addObject("user", editedPerson);
		model.addObject("donors",dao.getDonors(editedPerson));
		model.addObject("recipients",dao.getRecipients(editedPerson));
		model.addObject("event", dao.getEvent(editedPerson));
		EventPlanner planner = new EventPlanner(dao.getEvent(editedPerson));
		model.addObject("dates", planner.getfutereDates());
			}
			}
		
		return model;
	}

}
