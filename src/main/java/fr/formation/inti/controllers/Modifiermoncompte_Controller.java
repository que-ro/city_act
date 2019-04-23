package fr.formation.inti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Modifiermoncompte_Controller {
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping(value = "/modifiermesinfos_method", method = RequestMethod.POST)
	public String modifiermesinfos_method(Model model)
	{	
		return "modifiermoncompte";
	}

}
