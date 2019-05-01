package fr.formation.inti.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Footer_Controller {
	
	Logger logger = LoggerFactory.getLogger(Footer_Controller.class);
	
	@RequestMapping("/nous_contacter")
	public String Qui_sommes_nous() 
	{
		logger.info("fr.formation.inti.controllers.Footer_Controller.java - method nous_contacter");
		return "qui_sommes_nous";
	}
	
	@RequestMapping("/copyright")
	public String copyright() 
	{
		logger.info("fr.formation.inti.controllers.Footer_Controller.java - method copyright");
		return "copyright";
	}
	
	@RequestMapping("/legal")
	public String legal() 
	{
		logger.info("fr.formation.inti.controllers.Footer_Controller.java - method legal");
		return "legal";
	}
}
