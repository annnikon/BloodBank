package ua.nure.nikonova.bloodbank.controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@RequestMapping("/")
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");		
		return model;
	}
}
