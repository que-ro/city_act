package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test_Controller {
	
	@RequestMapping("/test")
	public String requestMapping(Model model)
	{
		return "map";
	}

}
