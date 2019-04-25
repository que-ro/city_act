package fr.formation.inti.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.repositories.IAmbientPowerDao;

@Controller
public class Formambientpower_Controller {
	
	@Autowired
	IAmbientPowerDao dao_ap;
	
	@RequestMapping(value = "/ambientpowerform_method", method = RequestMethod.POST)
	public String ambientpowerform_method(HttpServletRequest request, Model model, @ModelAttribute @Valid AmbientPower ambientPower, BindingResult bindingResult)
	{	
		if(bindingResult.hasErrors())
		{
			return "formambientpower";
		}
		ambientPower.setDateCreation(new Date());
		Integer maxId = dao_ap.getMaxId();
		if(maxId != null)
		{
			//En base de donnée un trigger mets un 3 devant les projets ambient power à des fins de reconnaissance
			//Pour donc mettre le bon id la procédure suivante cherche le max id, enlève son 3, l'incrémente
			//et l'associe au nouvel objet Ambient Power.
			Integer newId = Integer.parseInt(((maxId.toString()).substring(1))) + 1;
			ambientPower.setIdambientpower(newId);
		}
		else
		{
			ambientPower.setIdambientpower(1);
		}
		dao_ap.save(ambientPower);
		return "accueil";
	}

}
