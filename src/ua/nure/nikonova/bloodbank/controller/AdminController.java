package ua.nure.nikonova.bloodbank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ua.nure.nikonova.bloodbank.dao.AdminDAO;
import ua.nure.nikonova.bloodbank.dao.PersonDAO;
import ua.nure.nikonova.bloodbank.model.Admin;
import ua.nure.nikonova.bloodbank.model.Person;

@RestController
public class AdminController {
	
	public AdminController() {
		super();
	
		
	}
	
	
	@RequestMapping(value="/admin/delete/{login}")
	public ModelAndView delete(@PathVariable("login") String login) {
		ModelAndView model = new ModelAndView();
		PersonDAO personDAO=new PersonDAO();
		Person p=personDAO.getByLogin(login);
		model.setViewName("admin");
		if (p==null) {
			
			model.addObject("error", "No person with login "+login);
		}
		
		else {
			if(!personDAO.delete(login)) {
				model.addObject("error", "Cannot delete person with login "+login);
			}
			
		}
		return model;
	}
	
	@RequestMapping(value="/admin/contact/{login}")
	public ModelAndView contact(@PathVariable("login") String login) {
		ModelAndView model = new ModelAndView();
		PersonDAO personDAO=new PersonDAO();
		Person p=personDAO.getByLogin(login);
		model.setViewName("admin");
		if (p==null) {
			
			model.addObject("error", "No person with login "+login);
		}
		
		else {
			String phone = p.getPhone();
			String text = "Hello, "+p.getName()+". Blood Bank Admin";
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
	
	
	
	@RequestMapping("/admin/all")
	public ModelAndView seeAll() {
		ModelAndView model = new ModelAndView();
		PersonDAO personDAO=new PersonDAO();
			
		model.setViewName("admin");	
		model.addObject("recipients", personDAO.getAllRecipients());
		model.addObject("donors", personDAO.getAllDonors());
		return model;
	}
	
	@RequestMapping(value="/admin/check", method=RequestMethod.POST)
	public ModelAndView check(@RequestParam("login") String login, @RequestParam("password") String password) {
		ModelAndView model = new ModelAndView();
		PersonDAO personDAO=new PersonDAO();
		AdminDAO adminDAO=new AdminDAO();
		Admin a = adminDAO.getAdminByLogin(login);
		if (a==null) {
			model.setViewName("hello");
			model.addObject("error", "No administrator with login "+login);
		}
		else if(!a.getPassword().equals(password)) {
			model.setViewName("hello");
			model.addObject("error", "Wrong password");
		}
		else {
		model.setViewName("admin");	
		model.addObject("admin", a);
		model.addObject("recipients", personDAO.getAllRecipients());
		model.addObject("donors", personDAO.getAllDonors());
		
		}
		return model;
	}
	
	

}
