package fr.formation.inti.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IAmbientPowerDao;

@Controller
public class Formambientpower_Controller {

	@Autowired
	IAmbientPowerDao dao_ap;
	
	@RequestMapping(value = "/formambientpower_method", method = RequestMethod.POST)
	public String formambientpower_method(Model model, @ModelAttribute @Valid AmbientPower ambientpower, BindingResult bindingResult)
	{	
		System.out.println(bindingResult.getAllErrors());
		System.out.println(ambientpower.getIdambientpower());
		return "formambientpower";
	}
}
