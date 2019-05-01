package fr.formation.inti.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.utils.Login_Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Modifiermoncompte_Controller {
	
	Logger logger = LoggerFactory.getLogger(Modifiermoncompte_Controller.class);
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping(value = "/modifiermesinfos_method", method = RequestMethod.POST)
	public String modifiermesinfos_method(HttpServletRequest request, Model model, @ModelAttribute @Valid Users user, BindingResult bindingResult, @RequestParam(name="repeated_pwd") String repeated_pwd)
	{	
		logger.info("fr.formation.inti.controllers.Modifiermoncompte_Controller.java - method modifiermesinfos_method");
		if(bindingResult.hasErrors())
		{
			logger.info("fr.formation.inti.controllers.Modifiermoncompte_Controller.java - method modifiermesinfos_method : bindingResulkt contains errors");
			return "modifiermoncompte";
		}
		else
		{
			if(!user.getPassword().equals(repeated_pwd))
			{
				logger.info("fr.formation.inti.controllers.Modifiermoncompte_Controller.java - method modifiermesinfos_method : password and confirmation are not the same");
				model.addAttribute("error_repeated_pwd_modifcompte", "Le mot de passe de confirmation ne correspond pas au mot de passe");
				return "modifiermoncompte";
			}
			else
			{
				Users persistent_usr = dao_usr.findByIdusers(((Users)request.getSession().getAttribute("user")).getIdusers());
				persistent_usr.setBirthdate(user.getBirthdate());
				persistent_usr.setCity(user.getCity());
				persistent_usr.setCountry(user.getCountry());
				persistent_usr.setFirstname(user.getFirstname());
				persistent_usr.setLastname(user.getLastname());
				persistent_usr.setMail(user.getMail());
				persistent_usr.setPassword(Login_Utils.hashPassword(user.getPassword()));
				persistent_usr.setPseudo(user.getPseudo());
				persistent_usr.setStreet(user.getStreet());
				persistent_usr.setZipcode(user.getZipcode());
				dao_usr.save(persistent_usr);
				logger.info("fr.formation.inti.controllers.Modifiermoncompte_Controller.java - method modifiermesinfos_method : modification of user " + persistent_usr.getIdusers() + " is saved");
				return "modifiermoncompte";
			}
		}
	}

}
