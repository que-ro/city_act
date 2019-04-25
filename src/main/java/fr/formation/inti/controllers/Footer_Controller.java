package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Footer_Controller {
	
	@RequestMapping("/nous_contacter")
	public String Qui_sommes_nous() 
	{
		return "qui_sommes_nous";
	}
	
	@RequestMapping("/copyright")
	public String copyright() 
	{
		return "copyright";
	}
	
	@RequestMapping("/legal")
	public String legal() 
	{
		return "legal";
	}
}
