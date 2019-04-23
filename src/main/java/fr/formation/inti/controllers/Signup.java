package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Signup {
	
	@RequestMapping(value="/signup", method = RequestMethod.GET, params= {"nom"})
	public void inscription(@RequestParam(value = "nom") String nom) {
		
	}

}
